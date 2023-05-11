package com.example.user.input;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Appservice {
	@Autowired
	UserRepository userrepo;
	
	public void save(User  user)
	{
		
		userrepo.save(user);
	}

}
