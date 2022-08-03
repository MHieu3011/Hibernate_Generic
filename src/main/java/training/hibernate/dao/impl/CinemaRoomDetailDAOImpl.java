package training.hibernate.dao.impl;

import training.hibernate.dao.CinemaRoomDetailDAO;
import training.hibernate.dao.generic.GenericDAOImpl;
import training.hibernate.entities.CinemaRoomDetail;

/**
 * @author HieuDM24
 * @date 8/1/2022
 */

public class CinemaRoomDetailDAOImpl extends GenericDAOImpl<CinemaRoomDetail, Integer> implements CinemaRoomDetailDAO {

    public CinemaRoomDetailDAOImpl() {
        setClazz(CinemaRoomDetail.class);
        setID(Integer.class);
    }
}
