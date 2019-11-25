package com.inti.formation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.formation.models.User;
import java.lang.String;
import java.util.List;

@Repository
public interface IUserRepository  extends JpaRepository<User, Long>{

	public List<User> findByNom(String nom);
	
}
