package pe.edu.cinertec.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.cinertec.web.model.Person;

public interface IPersonRepository extends JpaRepository<Person, Integer> {

}
