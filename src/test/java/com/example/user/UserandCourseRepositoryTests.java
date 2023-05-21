package com.example.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import com.example.user.course.Course;
import com.example.user.course.CourseRepository;
import com.example.user.input.User;
import com.example.user.input.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserandCourseRepositoryTests {
	
	@Autowired
	private  UserRepository userrepos;
	@Autowired
	private  CourseRepository courserepo;

	@Test
	@Order(3)
	@Rollback(false)
	public void saveusertest() {
		
		User user = new User("John","doe","doe123","john@.gcom");
		User usersave = userrepos.save(user);
		
		assertNotNull(usersave);
		
	}
	
	@Test
	@Order(1)
	@Rollback(false)
	public void coursenotnull() {
		Course crs = new Course(1L,"Master Java","Google",1000);
		Course cr = courserepo.save(crs);
		assertNotNull(cr);
	}
	
	@Test
	@Order(2)
	@Rollback(false)
	public void matchcoursenamewithcasesensitive() {
		
		Course crs = courserepo.findById(1L).get();
		assertNotEquals("Master Python", crs.getCname());
		
	}
	
	@Test
	@Order(4)
	@Rollback(false)
	public void updatecourseprovider() {
		Course crs = courserepo.findById(1L).get();
		crs.setCprovider("Michigan University");
		Course cs = courserepo.save(crs);
		
		//assertSame("Michigan University",cs.getCprovider());
		Assertions.assertThat(cs.getCprovider()).isEqualTo("Michigan University");
		
	}

	
}
