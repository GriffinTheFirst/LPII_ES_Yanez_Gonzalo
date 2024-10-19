package pe.edu.cinertec.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.cinertec.web.model.Role;

public interface IRoleRepository extends JpaRepository<Role, Integer> {

}
