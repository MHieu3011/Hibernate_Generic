package training.hibernate.dao.impl;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import training.hibernate.dao.CinemaRoomDAO;
import training.hibernate.dao.generic.GenericDAOImpl;
import training.hibernate.entities.CinemaRoom;

import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

/**
 * @author HieuDM24
 * @date 8/1/2022
 */

@Slf4j
public class CinemaRoomDAOImpl extends GenericDAOImpl<CinemaRoom, Integer> implements CinemaRoomDAO {

    public CinemaRoomDAOImpl() {
        setClazz(CinemaRoom.class);
        setID(Integer.class);
    }

    @Override
    public CinemaRoom testSto_Query() {
        log.debug("Find all start with Query {}, {}", clazz, id);
        CinemaRoom result = null;
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            Query query = session.createSQLQuery("EXEC sto_findAlllRoom :id").addEntity(CinemaRoom.class);
            query.setParameter("id", 1);
            result = (CinemaRoom) query.getSingleResult();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        log.debug("Find all end with {}, {}", clazz, id);
        return result;
    }

    @Override
    public CinemaRoom testSto_StoredProcedureQuery() {
        log.debug("Find all start with StoredProcedureQuery {}, {}", clazz, id);
        CinemaRoom result = null;
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            StoredProcedureQuery query = session.createStoredProcedureQuery("sto_findAlllRoom", CinemaRoom.class);
            query.registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN);
            query.setParameter("id", 1);
            result = (CinemaRoom) query.getSingleResult();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        log.debug("Find all end with {}, {}", clazz, id);
        return result;
    }

    @Override
    public String testSto_Output() {
        log.debug("Find all start with StoredProcedureQuery {}, {}", clazz, id);
        String result = null;
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            StoredProcedureQuery query = session.createStoredProcedureQuery("sto_findName");
            query.registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("name", String.class, ParameterMode.OUT);
            query.setParameter("id", 1);
            result = (String) query.getOutputParameterValue("name");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        log.debug("Find all end with {}, {}", clazz, id);
        return result;
    }
}
