package training.hibernate.dao.generic;

import java.util.List;

/**
 * @author HieuDM24
 * @date 8/1/2022
 */

public interface GenericDAO<T, ID> {

    T findOne(final ID id);

    List<T> findAll();

    T create(final T entity);

    T update(final T entity);

    void delete(final T entity);

    void deleteById(final ID entityId);
}
