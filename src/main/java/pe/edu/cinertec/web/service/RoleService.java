package pe.edu.cinertec.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.cinertec.web.model.Role;
import pe.edu.cinertec.web.repository.IRoleRepository;

@Service
public class RoleService {

	@Autowired
	private IRoleRepository rolRepo;
	
	public Role updateUserLogin(Role role) {
//		User u = userRepository.getReferenceById(user.getIduser());
		return rolRepo.save(role);
	}
	
	public Role crearRol(Role role) {
		return rolRepo.save(role);
	}
	
	public List<Role> listadoRol() {
		List<Role> listaRol = rolRepo.findAll();
		return listaRol;
	}
	
	public void eliminarRol(String id) {
		rolRepo.deleteById(Integer.parseInt(id));
	}
	
	public Role buscarRol(String id) {
		Role rol = rolRepo.getById(Integer.parseInt(id));
		return rol;
	}
}