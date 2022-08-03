package fa.hibernate.test;

import org.junit.Test;
import training.hibernate.dao.CinemaRoomDetailDAO;
import training.hibernate.dao.impl.CinemaRoomDetailDAOImpl;
import training.hibernate.entities.CinemaRoom;
import training.hibernate.entities.CinemaRoomDetail;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * @author HieuDM24
 * @date 8/2/2022
 */

public class CinemaRoomDetailDAOTest {

    private CinemaRoomDetailDAO dao = new CinemaRoomDetailDAOImpl();

    @Test
    public void testCreate() {
        CinemaRoom cinemaRoom = new CinemaRoom();
        cinemaRoom.setRoomId(Integer.valueOf(1));
        CinemaRoomDetail cinemaRoomDetail = new CinemaRoomDetail(Integer.valueOf(1), Integer.valueOf(1), LocalDate.now(), "description", cinemaRoom);
        dao.create(cinemaRoomDetail);
        assertTrue(true);
    }

    @Test
    public void testFindOne() {
        CinemaRoomDetail cinemaRoomDetail = dao.findOne(Integer.valueOf(1));
        System.out.println(cinemaRoomDetail);
        assertTrue(true);
    }

    @Test
    public void testUpdate() {
        CinemaRoom cinemaRoom = new CinemaRoom();
        cinemaRoom.setRoomId(Integer.valueOf(1));
        CinemaRoomDetail cinemaRoomDetail = new CinemaRoomDetail(Integer.valueOf(1), Integer.valueOf(5), LocalDate.now(), "description new", cinemaRoom);
        dao.update(cinemaRoomDetail);
        assertTrue(true);
    }

    @Test
    public void testFindAll() {
        List<CinemaRoomDetail> list = dao.findAll();
        list.forEach(System.out::println);
        assertTrue(true);
    }

    @Test
    public void testDelete() {
        CinemaRoom cinemaRoom = new CinemaRoom();
        cinemaRoom.setRoomId(Integer.valueOf(1));
        CinemaRoomDetail cinemaRoomDetail = new CinemaRoomDetail(Integer.valueOf(1), Integer.valueOf(5), LocalDate.now(), "description new", cinemaRoom);
        dao.delete(cinemaRoomDetail);
        assertTrue(true);
    }

    @Test
    public void testDeleteById() {
        dao.deleteById(Integer.valueOf(1));
        assertTrue(true);
    }
}
