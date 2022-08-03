package fa.hibernate.test;

import org.junit.Test;
import training.hibernate.dao.CinemaRoomDAO;
import training.hibernate.dao.impl.CinemaRoomDAOImpl;
import training.hibernate.entities.CinemaRoom;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * @author HieuDM24
 * @date 8/2/2022
 */

public class CinemaRoomDAOTest {

    private CinemaRoomDAO dao = new CinemaRoomDAOImpl();

    @Test
    public void testCreate() {
        CinemaRoom cinemaRoom = CinemaRoom
                .builder()
                .roomId(Integer.valueOf(1))
                .roomName("Thuong Tin")
                .seatQuantity(50)
                .build();
        cinemaRoom = dao.create(cinemaRoom);
        System.out.println(cinemaRoom);
        assertTrue(true);
    }

    @Test
    public void testFindOne() {
        CinemaRoom cinemaRoom = dao.findOne(Integer.valueOf(1));
        System.out.println(cinemaRoom);
        assertTrue(true);
    }

    @Test
    public void testUpdate() {
        CinemaRoom cinemaRoom = CinemaRoom
                .builder()
                .roomId(Integer.valueOf(1))
                .roomName("Thuong Tin")
                .seatQuantity(60)
                .build();
        cinemaRoom = dao.update(cinemaRoom);
        System.out.println(cinemaRoom);
        assertTrue(true);
    }

    @Test
    public void testFindAll() {
        List<CinemaRoom> list = dao.findAll();
        list.forEach(System.out::println);
        assertTrue(true);
    }

    @Test
    public void testDelete() {
        CinemaRoom cinemaRoom = CinemaRoom
                .builder()
                .roomId(Integer.valueOf(1))
                .roomName("Thuong Tin")
                .seatQuantity(60)
                .build();
        dao.delete(cinemaRoom);
        assertTrue(true);
    }

    @Test
    public void testDeleteById() {
        dao.deleteById(Integer.valueOf(1));
        assertTrue(true);
    }

    @Test
    public void testSto_Query() {
        CinemaRoom list = dao.testSto_Query();
        System.out.println(list);
        assertTrue(true);
    }

    @Test
    public void testSto_StoredProcedureQuery() {
        CinemaRoom list = dao.testSto_StoredProcedureQuery();
        System.out.println(list);
        assertTrue(true);
    }

    @Test
    public void testSto_Output() {
        String list = dao.testSto_Output();
        System.out.println(list);
        assertTrue(true);
    }


}
