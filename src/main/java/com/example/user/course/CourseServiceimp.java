package com.example.user.course;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CourseServiceimp implements CourseService {

	@Autowired
	private CourseRepository courserepo;
	@Override
	public List<Course> getAllcourse() {
		return courserepo.findAll();
		
	}
	
	public void save(Course course)
	{
		
		courserepo.save(course);
	}

	@Override
	public Course getCoursebyid(long id) {
		Optional<Course> optional = courserepo.findById(id);
		Course course = null;
		if(optional.isPresent()) {
			course=optional.get();
		}
		else {
			throw new RuntimeException("Course Not Found for id :: " +id);
			
		}
		return course;
	}

	@Override
	public void deletecoursebyid(long id) {
		this.courserepo.deleteById(id);
		
	}

}
