package training.hibernate.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author HieuDM24
 * @date 8/1/2022
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "cinema_room_detail")
public class CinemaRoomDetail {

    @Id
    @Column(name = "room_detail_id")
    private Integer roomDetailId;

    @Column(name = "room_rate")
    private Integer roomRate;

    @Column(name = "active_date")
    private LocalDate activeDate;

    @Column(name = "room_description", columnDefinition = "nvarchar(250)")
    private String roomDescription;

    @OneToOne
    @JoinColumn(name = "cinema_room_id", nullable = false)
    private CinemaRoom cinemaRoom;

}
