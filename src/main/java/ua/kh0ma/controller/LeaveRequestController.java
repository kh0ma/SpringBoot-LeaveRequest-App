package ua.kh0ma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ua.kh0ma.model.LeaveRequest;
import ua.kh0ma.repository.LeaveRequestRepository;

import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * Created by kh0ma on 02.06.17.
 */
@RestController
@RequestMapping(value = "/ajax/leaverequest")
public class LeaveRequestController {

    @Autowired
    private LeaveRequestRepository repository;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody LeaveRequest leaveRequest) {
        long between = ChronoUnit.DAYS.between(leaveRequest.getDateStart(), leaveRequest.getDateEnd());
        leaveRequest.setCountDays((int) between);
        repository.save(leaveRequest,1);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LeaveRequest> getAll() {
        return repository.getAll(1);
    }

}
