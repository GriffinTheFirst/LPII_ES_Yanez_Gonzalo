package pe.edu.cinertec.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.edu.cinertec.web.model.User;

public interface IUserRepository extends JpaRepository<User, Integer> {

	@Query("SELECT u FROM User u WHERE u.name = ?1 AND u.password = ?2")
	User findByUserAndPassword(String name, String password);
}
