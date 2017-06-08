package ua.kh0ma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ua.kh0ma.model.LeaveRequest;
import ua.kh0ma.repository.LeaveRequestRepository;
import ua.kh0ma.repository.UserRepository;

import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * Created by kh0ma on 02.06.17.
 */
@RestController
@RequestMapping(value = "/ajax/leaverequest")
public class LeaveRequestController {

    @Autowired private LeaveRequestRepository repository;

    @Autowired private UserRepository userRepository;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody LeaveRequest leaveRequest) {
        long between = ChronoUnit.DAYS.between(leaveRequest.getDateStart(), leaveRequest.getDateEnd());
        leaveRequest.setCountDays((int) between);
        leaveRequest.setUser(userRepository.findOne(1));
        repository.save(leaveRequest);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LeaveRequest> getAll() {
        return repository.findAllForUserId(1);
    }

}
