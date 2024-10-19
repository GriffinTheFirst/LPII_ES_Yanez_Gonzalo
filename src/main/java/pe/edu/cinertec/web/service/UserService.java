package pe.edu.cinertec.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.cinertec.web.model.User;
import pe.edu.cinertec.web.repository.IUserRepository;

@Service
public class UserService {
	
	@Autowired
	private IUserRepository userRepository;
	
	public User validateUserByNameAndPassword(String name, String password) {
		User u = userRepository.findByUserAndPassword(name, password);
		return u;
	}
}
