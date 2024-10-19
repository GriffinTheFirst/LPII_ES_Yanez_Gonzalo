package pe.edu.cinertec.thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pe.edu.cinertec.web.model.Person;
import pe.edu.cinertec.web.model.Role;
import pe.edu.cinertec.web.model.User;
import pe.edu.cinertec.web.repository.IPersonRepository;
import pe.edu.cinertec.web.repository.IRoleRepository;
import pe.edu.cinertec.web.service.RoleService;
import pe.edu.cinertec.web.service.UserService;

@Controller
public class SustiController {
	
	@Autowired
	private RoleService repos;
	
	@Autowired
	private IPersonRepository reposPerson;
	
	@Autowired
	private UserService userService;
	
	@GetMapping({"/","/login"})
	public String login(Model model) {
		System.out.println("Mostrando login");
		User Unew = new User();
		model.addAttribute("userLogin", Unew);
		return "login";
	}
	@PostMapping("/login")
	public String login(@ModelAttribute User user, Model model) {
		System.out.println("Validando login");		
		String redirect = "login";
		User u = userService.validateUserByNameAndPassword(user.getName(), user.getPassword());
		if (u != null) {
			return "redirect:/listado";
		} else {
			model.addAttribute("errors", "Usuario o clave incorrectos");
			model.addAttribute("userLogin", new User());
		}
		return redirect;
	}
	
	
	@GetMapping("/listado")
	public String listado(Model model) {
		try {
			model.addAttribute("ltsRole", repos.listadoRol());
			model.addAttribute("ltsPerson", reposPerson.findAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "listado";
	}
	
	
	@GetMapping("/createRole")
	public String createRole(Model model) {
		System.out.println("Abriendo crear role");
		model.addAttribute("crearRole", new Role());
		return "createRole";
	}
	@PostMapping("/createRole")
	public String createRole(@ModelAttribute Role role, Model model) {
		System.out.println("Creando role");
		repos.crearRol(role);
		model.addAttribute("msj", "Inserción realizada");
		model.addAttribute("crearRole", new Role());
		createRole(model);
		return "createRole";
	}
	
	@GetMapping("/updateRole/{idrole}")
	public String updateRole(@PathVariable String idrole, Model model) {
		System.out.println("Ejecutando actualizar rol" + idrole);
		model.addAttribute("updRol", repos.buscarRol(idrole));
		return "updateRole";
	}
	@PostMapping("/updateRole")
	public String updateRole(@ModelAttribute Role role, Model model) {
		System.out.println("Actualizando role");
		repos.crearRol(role);
		model.addAttribute("msj", "Update realizada");
		return "redirect:/listado";
	}
	
	@GetMapping("/deleteRole/{idrole}")
	public String deleteRole(@PathVariable String idrole, Model model) {
		System.out.println("Ejecutando eliminar rol" + idrole);
		repos.eliminarRol(idrole);
		return "redirect:/listado";
	}
	
	
	@GetMapping("/createPerson")
	public String createPerson(Model model) {
		System.out.println("Abriendo crear person");
		model.addAttribute("crearPerson", new Person());
		return "createPerson";
	}
	@PostMapping("/createPerson")
	public String createPerson(@ModelAttribute Person person, Model model) {
		System.out.println("Creando person");
		reposPerson.save(person);
		model.addAttribute("msj", "Inserción realizada");
		model.addAttribute("crearPerson", new Person());
		createPerson(model);
		return "createPerson";
	}
	
	@GetMapping("/updatePerson/{idperson}")
	public String updatePerson(@PathVariable String idperson, Model model) {
		System.out.println("Ejecutando actualizar rol" + idperson);
		Person persona = reposPerson.getById(Integer.parseInt(idperson));
		model.addAttribute("updPer", persona);
		return "updatePerson";
	}
	@PostMapping("/updatePerson")
	public String updatePerson(@ModelAttribute Person person, Model model) {
		System.out.println("Actualizando person");
		reposPerson.save(person);
		model.addAttribute("msj", "Update realizada");
		model.addAttribute("updPer", new Person());
		return "redirect:/listado";
	}
	
	@GetMapping("/deletePerson/{idperson}")
	public String deletePerson(@PathVariable String idperson, Model model) {
		System.out.println("Ejecutando eliminar person" + idperson);
		reposPerson.deleteById(Integer.parseInt(idperson));
		return "redirect:/listado";
	}
}
