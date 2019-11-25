package com.inti.formation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.inti.formation.models.User;
import com.inti.formation.repositories.IUserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepoTest {
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private IUserRepository userRepository;

	@Test
	public void saveUserTest() {

		User user = new User(8, "test", "test");

		entityManager.persist(user);

		User getFromDb = userRepository.getOne(user.getId());
		assertThat(getFromDb).isEqualTo(user);

	}

	@Test
	public void FindByNomTest() {
		// given
		User user = new User(9, "Nasri", "Samir");
		entityManager.persist(user);

		// when
		List<User> found = userRepository.findByNom(user.getNom());

		// then
		assertThat(found.get(0).getNom()).isEqualTo(user.getNom());
	}

	@Test
	public void getByIdTest() {
		User user = new User(9, "Nasri", "Samir");
		entityManager.persist(user);
		User found = userRepository.getOne(user.getId());
		assertThat(found).isNotNull();

	}
	
	@Test
	public void getAllTest() {
		
		User user = new User(9, "Nasri", "Samir");
		User user1 = new User(10, "Nasri", "Sami");
		User user2 = new User(11, "Mahrez", "Riadh");
	   
		entityManager.persist(user);
		entityManager.persist(user1);
		entityManager.persist(user2);
		
		List<User>users = userRepository.findAll();
		assertThat(users).isNotEmpty();

	}
	
	@Test
	public void deleteTest() {
		User user = new User(9, "Nasri", "Samir");
		User user1 = new User(10, "Nasri", "Sami");
		entityManager.persist(user);
		entityManager.persist(user1);
		entityManager.remove(user);
		
		assertEquals(1, userRepository.findAll().size());
		
	}
	
	@Test
	public void updateTest() {
		
		User user = new User(9, "Nasir", "Samir");
		
		entityManager.persist(user);
		
		user.setNom("Nasri");
		entityManager.merge(user);
		
	
		assertEquals(user, userRepository.getOne(user.getId()));
		
		
	}

}
