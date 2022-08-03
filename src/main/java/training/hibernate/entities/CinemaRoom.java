package training.hibernate.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author HieuDM24
 * @date 8/1/2022
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString
public class CinemaRoom {

    @Id
    @Column(name = "room_id")
    private Integer roomId;

    @Column(name = "room_name", columnDefinition = "nvarchar(255)", unique = true)
    private String roomName;

    @Column(name = "seat_quantity")
    private Integer seatQuantity;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cinemaRoom")
    @ToString.Exclude
    private List<Seat> seatList = new ArrayList<>();

}
