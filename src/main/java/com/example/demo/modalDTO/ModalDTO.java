package com.example.demo.modalDTO;

import java.util.Date;
import java.util.List;

import com.example.demo.entity.Users;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModalDTO {

	private Integer userId;
	private String name;
	private String seatNo;
	
	private List<PaymentDTO> payment;
	
}


