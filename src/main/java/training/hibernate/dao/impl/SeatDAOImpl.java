package training.hibernate.dao.impl;

import training.hibernate.dao.SeatDAO;
import training.hibernate.dao.generic.GenericDAOImpl;
import training.hibernate.entities.Seat;

/**
 * @author HieuDM24
 * @date 8/1/2022
 */

public class SeatDAOImpl extends GenericDAOImpl<Seat, Integer> implements SeatDAO {

    public SeatDAOImpl() {
        setClazz(Seat.class);
        setID(Integer.class);
    }

}
