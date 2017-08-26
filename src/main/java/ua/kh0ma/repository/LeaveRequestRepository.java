package ua.kh0ma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import ua.kh0ma.model.LeaveRequest;

import java.util.List;

/**
 * Created by kh0ma on 02.06.17.
 */
public interface LeaveRequestRepository extends JpaRepository<LeaveRequest,Integer>{
    @Query("select lr from LeaveRequest lr where lr.user.id=:id")
    List<LeaveRequest> findAllForUserId(@Param("id") Integer id);
}
