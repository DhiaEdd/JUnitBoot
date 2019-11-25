package com.inti.formation.webservices;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.formation.models.User;
import com.inti.formation.service.IUserService;



@RestController
@RequestMapping("/apiUser")
@CrossOrigin("*")
public class UserRestController {
	
	@Autowired
	private IUserService metier;
	
	@RequestMapping(value="/ajouter",method=RequestMethod.POST)
	public User ajouter(@RequestBody User j) {
		
		return metier.ajoutUser(j);
	}
	@RequestMapping(value="/update",method=RequestMethod.PUT)
	public User update(@RequestBody User j) {
		 
		return metier.updateUser(j);
	}
	@RequestMapping(value="/get/{id}",method=RequestMethod.GET)
	public User getById(@PathVariable long id)
	{
		return metier.getUser(id);
		
	}
	@RequestMapping(value="/users",method=RequestMethod.GET)
	public List<User> findAll(){
		
		return metier.getAll();
		
	}
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		
		metier.deleteUser(id);
	}

}

