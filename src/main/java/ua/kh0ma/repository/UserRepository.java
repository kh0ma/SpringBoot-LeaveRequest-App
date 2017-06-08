package ua.kh0ma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kh0ma.model.User;

/**
 * Created by kh0ma on 08.06.17.
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}
