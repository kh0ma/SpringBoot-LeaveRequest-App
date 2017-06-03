package ua.kh0ma.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Created by kh0ma on 02.06.17.
 */

@Entity
@Table(name="leave_request")
@NamedQuery(name = LeaveRequest.ALL, query = "SELECT lr FROM LeaveRequest lr WHERE lr.user.id=:userId")
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public LocalDateTime getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDateTime dateStart) {
        this.dateStart = dateStart;
    }

    public LocalDateTime getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDateTime dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Integer getCountDays() {
        return countDays;
    }

    public void setCountDays(Integer countDays) {
        this.countDays = countDays;
    }

    @Override
    public String toString() {
        return "LeaveRequest{" +
                "id=" + id +
                ", user=" + user +
                ", dateStart=" + dateStart +
                ", dateEnd=" + dateEnd +
                ", countDays=" + countDays +
                '}';
    }
}
