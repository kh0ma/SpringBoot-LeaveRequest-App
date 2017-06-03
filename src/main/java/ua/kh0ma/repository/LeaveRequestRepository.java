package ua.kh0ma.repository;

import ua.kh0ma.model.LeaveRequest;

import java.util.List;

/**
 * Created by kh0ma on 02.06.17.
 */
public interface LeaveRequestRepository {
    LeaveRequest save(LeaveRequest leaveRequest, int userId);
    List<LeaveRequest> getAll(int userId);
}
