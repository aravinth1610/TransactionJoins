package com.example.demo.entity;

import java.util.Date;

import org.hibernate.annotations.DynamicInsert;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="payments")
@DynamicInsert
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="paymentid")
	private Integer id;

	
	private String paied;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy HH:mm:ss")
	@Column(name = "createon", length = 24)
	private Date createOn;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy HH:mm:ss")
	@Column(name = "updateon", length = 24)
	private Date updateOn;
	
	@ManyToOne
	@JoinColumn(name="pk_user",referencedColumnName = "userid") 
	@JsonIgnore
	private Users user;

	public Payment(String paied, Date createOn, Date updateOn) {
		super();
		this.paied = paied;
		this.createOn = createOn;
		this.updateOn = updateOn;
	}
	
	
}