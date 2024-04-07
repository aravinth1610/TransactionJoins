package com.example.demo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modalDTO.ModalDTO;
import com.example.demo.serv.UserDataSave;


@RestController
public class SeCont {

	@Autowired
	private UserDataSave sv;
	
	@GetMapping("/gt")
	private String sv() {
		return sv.saveData();
	}
	
	@PostMapping("/postmapper")
	private void testModalMapper(@RequestBody ModalDTO modalDto) {
		 sv.testMapper(modalDto);
	}
	
}
