package training.hibernate.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author HieuDM24
 * @date 8/1/2022
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "seat")
public class Seat {

    @Id
    @Column(name = "seat_id")
    private Integer seatId;

    @Column(name = "seat_column", columnDefinition = "nvarchar(255)")
    private String seatColumn;

    @Column(name = "seat_row")
    private Integer seatRow;

    @Column(name = "seat_status", columnDefinition = "nvarchar(255)")
    @Enumerated(EnumType.STRING)
    private SeatStatus seatStatus;

    @Column(name = "seat_type", columnDefinition = "nvarchar(255)")
    @Enumerated(EnumType.STRING)
    private SeatType seatType;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "room_id", nullable = false)
    private CinemaRoom cinemaRoom;

}
