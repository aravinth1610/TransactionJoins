package com.example.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * We can use on Many to Many and Many to one 
 * This will not do Bi-direction i.e if list of use is their we need all data
 *    we used to call both mapped Class so will be looped so for this we use 
 * @JsonBackReference --> This is need to use as parent
 * @JsonManagedReference --> This is need to use as child 
*/

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="pay_users")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pay_usersid")
	private Integer id;
	@Column(name = "userid",unique = true)
	private Integer userId;

	private String name;
	private String seatNo;
	
	
	
	//mappedBy need to as Child
	@OneToMany(mappedBy = "user",cascade  = CascadeType.ALL)
	private List<Payment> payment;

	public Users(Integer userId,String name, String seatNo, List<Payment> payment) {
		super();
		this.name = name;
		this.seatNo = seatNo;
		this.payment = payment;
		this.userId=userId;
	}
	
}
