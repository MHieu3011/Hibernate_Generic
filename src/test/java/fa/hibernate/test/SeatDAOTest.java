package fa.hibernate.test;


import org.junit.Test;
import training.hibernate.dao.SeatDAO;
import training.hibernate.dao.impl.SeatDAOImpl;
import training.hibernate.entities.CinemaRoom;
import training.hibernate.entities.Seat;
import training.hibernate.entities.SeatStatus;
import training.hibernate.entities.SeatType;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * @author HieuDM24
 * @date 8/2/2022
 */

public class SeatDAOTest {

    private SeatDAO dao = new SeatDAOImpl();

    @Test
    public void testCreate() {
        CinemaRoom cinemaRoom = new CinemaRoom();
        cinemaRoom.setRoomId(Integer.valueOf(1));
        Seat seat = new Seat(Integer.valueOf(1), "ABC", Integer.valueOf(3), SeatStatus.Avalible, SeatType.Normal, cinemaRoom);
        dao.create(seat);
        assertTrue(true);
    }

    @Test
    public void testFindOne() {
        Seat seat = dao.findOne(Integer.valueOf(1));
        System.out.println(seat);
        assertTrue(true);
    }

    @Test
    public void testUpdate() {
        CinemaRoom cinemaRoom = new CinemaRoom();
        cinemaRoom.setRoomId(Integer.valueOf(1));
        Seat seat = new Seat(Integer.valueOf(1), "XYZ", Integer.valueOf(3), SeatStatus.Booked, SeatType.VIP, cinemaRoom);
        dao.update(seat);
        assertTrue(true);
    }

    @Test
    public void testFindAll() {
        List<Seat> list = dao.findAll();
        list.forEach(System.out::println);
        assertTrue(true);
    }

    @Test
    public void testDelete() {
        CinemaRoom cinemaRoom = new CinemaRoom();
        cinemaRoom.setRoomId(Integer.valueOf(1));
        Seat seat = new Seat(Integer.valueOf(1), "XYZ", Integer.valueOf(3), SeatStatus.Booked, SeatType.VIP, cinemaRoom);
        dao.delete(seat);
        assertTrue(true);
    }

    @Test
    public void testDeleteById() {
        dao.deleteById(Integer.valueOf(1));
        assertTrue(true);
    }
}
