package training.hibernate.dao.generic;

import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import training.hibernate.entities.Seat;
import training.hibernate.utils.HibernateUtils;

import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

/**
 * @author HieuDM24
 * @date 8/1/2022
 */

@Slf4j
public abstract class GenericDAOImpl<T, ID> implements GenericDAO<T, ID> {

    protected SessionFactory factory = HibernateUtils.getSessionFactory();
    protected Class<T> clazz;
    protected Class<ID> id;

    public void setClazz(final Class<T> clazzToSet) {
        clazz = Preconditions.checkNotNull(clazzToSet);
    }

    public void setID(final Class<ID> idClazz) {
        id = Preconditions.checkNotNull(idClazz);
    }

    @Override
    public T findOne(ID id) {
        log.debug("Find one start with {}, {}", clazz, id);
        T result = null;
        try (Session session = factory.openSession()) {
            session.beginTransaction();
//            result = session.find(clazz, id);
            result = session.get(clazz, (Serializable) id);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        log.debug("Find one end with {}, {}", clazz, id);
        return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> findAll() {
        log.debug("Find all start with {}, {}", clazz, id);
        List<T> result = null;
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("FROM " + clazz.getName());
            result = query.getResultList();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        log.debug("Find all end with {}, {}", clazz, id);
        return result;
    }

    @Override
    public T create(T entity) {
        log.debug("Create start with {}, {}", clazz, id);
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                log.warn("Rollback transaction!");
            }
            log.error(e.getMessage());
        }
        log.debug("Create end with {}, {}", clazz, id);
        return entity;
    }

    @Override
    public T update(T entity) {
        log.debug("Update start with {}, {}", clazz, id);
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            session.merge(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                log.warn("Rollback transaction!");
            }
            log.error(e.getMessage());
        }
        log.debug("Update end with {}, {}", clazz, id);
        return entity;
    }

    @Override
    public void delete(T entity) {
        log.debug("Delete start with {}, {}", clazz, id);
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            session.remove(entity);
            transaction.commit();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        log.debug("Delete end with {}, {}", clazz, id);
    }

    @Override
    public void deleteById(ID entityId) {
        log.debug("Delete by ID start with {}, {}", clazz, id);
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            final T entity = findOne(entityId);
            session.remove(entity);
            transaction.commit();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        log.debug("Delete by ID end with {}, {}", clazz, id);
    }

}
