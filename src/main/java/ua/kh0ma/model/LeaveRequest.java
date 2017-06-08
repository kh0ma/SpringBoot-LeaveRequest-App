package ua.kh0ma.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Created by kh0ma on 02.06.17.
 */

@Entity
@Table(name="leave_request")
@NamedQuery(name = LeaveRequest.ALL, query = "SELECT lr FROM LeaveRequest lr WHERE lr.user.id=:userId")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class LeaveRequest {
    public static final String ALL = "LeaveRequest.getAll";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @NotNull
    private LocalDateTime dateStart;

    @NotNull
    private LocalDateTime dateEnd;

    @NotNull
    private Integer countDays;
}
