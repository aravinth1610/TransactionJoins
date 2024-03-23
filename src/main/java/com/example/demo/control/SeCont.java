package com.example.demo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.serv.UserDataSave;


@RestController
public class SeCont {

	@Autowired
	private UserDataSave sv;
	
	@GetMapping("/gt")
	private String sv() {
		return sv.saveData();
	}
	
}
