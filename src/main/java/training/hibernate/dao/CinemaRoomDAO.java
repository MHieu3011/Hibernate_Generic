package training.hibernate.dao;

import training.hibernate.dao.generic.GenericDAO;
import training.hibernate.entities.CinemaRoom;

/**
 * @author HieuDM24
 * @date 8/1/2022
 */

public interface CinemaRoomDAO extends GenericDAO<CinemaRoom, Integer> {

    CinemaRoom testSto_Query();

    CinemaRoom testSto_StoredProcedureQuery();

    String testSto_Output();
}
