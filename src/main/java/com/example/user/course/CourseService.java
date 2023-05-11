package com.example.user.course;

import java.util.List;

public interface CourseService {
	List<Course> getAllcourse();
	void save(Course course);
	Course getCoursebyid(long id);
	void deletecoursebyid(long id);

}
