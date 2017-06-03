package ua.kh0ma.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.kh0ma.model.LeaveRequest;
import ua.kh0ma.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by kh0ma on 02.06.17.
 */
@Repository
public class LeaveRequestRepositoryImpl implements LeaveRequestRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public LeaveRequest save(LeaveRequest leaveRequest, int userId) {
        leaveRequest.setUser(em.getReference(User.class, userId));
        em.persist(leaveRequest);
        return leaveRequest;
    }

    @Override
    public List<LeaveRequest> getAll(int userId) {
        return em.createNamedQuery(LeaveRequest.ALL, LeaveRequest.class)
                .setParameter("userId", userId)
                .getResultList();
    }
}
