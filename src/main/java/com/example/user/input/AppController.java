package com.example.user.input;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.user.course.Course;
import com.example.user.course.CourseService;

@Controller
public class AppController {
	
	@Autowired
	Appservice userservice;
	@Autowired
	CourseService courseserv;
	
	@GetMapping(value="/")
	public String homepage() {
		
		return "homepage";
	}
	
	 @GetMapping(value = "/register")
	  public String registerUser(Model model) { 
	    model.addAttribute("user", new User());
	    return "signup_form";
	  }
	 
	 
	 
	 @PostMapping("/process_login")
	 public String processRegister(User user) {
	     BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	     String encodedPassword = passwordEncoder.encode(user.getPassword());
	     user.setPassword(encodedPassword);
	      
	     userservice.save(user);
	      
	     return "register_success";
	 }
	 
	 @RequestMapping("/users")
	 public String disp(){
	     //List<User> listUsers = userRepo.findAll();
	     //model.addAttribute("listUsers", listUsers);
	      
	     return "userViewOfcourse";
	 }
	 
	 @GetMapping("/dispUsercourse")
	 public String showUserCourse(Model model) {
	     List<Course> listUsers = courseserv.getAllcourse();
	     model.addAttribute("listUsers", listUsers); 
	     return "userViewOfcourse";
	 }
	 
	 
	 @GetMapping("/adminlogin")
	 public String admin(Model model) {
	   
	     return "adminpage";
	 }
	 @PostMapping("/adminlogin")
	 public String adminback(Model model) {
	   
	     return "adminpage";
	 }
	 
	 
	
	 
	 @GetMapping(value = "/addcourse")
	  public String addcourses(Model model) { 
	    model.addAttribute("course", new Course());
	    return "addcourse";
	  }
	 
	 @PostMapping("/save")
	 public String savecourse(@ModelAttribute("course") Course course) {
	     
		 courseserv.save(course);
		 return "redirect:/dispcourse";
	     
	 }
	 
	 @PostMapping("/dispcourse")
	 public String listUser(Model model) {
	     List<Course> listUsers = courseserv.getAllcourse();
	     model.addAttribute("listUsers", listUsers); 
	     return "course";
	 }
	 
	 @GetMapping("/dispcourse")
	 public String listUsers(Model model) {
	     List<Course> listUsers = courseserv.getAllcourse();
	     model.addAttribute("listUsers", listUsers); 
	     return "course";
	 }
	 
	 @GetMapping("/updatecourse/{id}")
	 public String updatecourse(@PathVariable(value = "id") long id, Model model) {
		
		 Course course = courseserv.getCoursebyid(id);
		 model.addAttribute("course",course);
		 
		 
		 return "update_course";
		 
	 }
	 
	 @GetMapping("/deletecourse/{id}")
	 public String deletecourse(@PathVariable (value ="id" )long id) {
		
		 this.courseserv.deletecoursebyid(id);
		 return "redirect:/dispcourse";
		 
	 
	 }

}
