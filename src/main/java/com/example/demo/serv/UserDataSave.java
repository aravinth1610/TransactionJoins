package com.example.demo.serv;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.OtherPayment;
import com.example.demo.entity.Payment;
import com.example.demo.entity.Users;
import com.example.demo.mapper.TestMapper;
import com.example.demo.modalDTO.ModalDTO;
import com.example.demo.repo.OtherPayRepo;
import com.example.demo.repo.UsersRepo;

import jakarta.transaction.Transactional;

@Service
public class UserDataSave {

	@Autowired
	private UsersRepo user;

	@Autowired
	private OtherPayRepo othpay;

	private final TestMapper mapper;

	public UserDataSave(TestMapper mapper) {
		this.mapper = mapper;
	}

	@Transactional
	public String saveData() {

		Users u = new Users();
		u.setUserId(234233434);
		u.setName("ara");
		u.setSeatNo("34");
		Payment pay = new Payment();
		pay.setPaied("true");
		pay.setCreateOn(new Date());
		pay.setUpdateOn(new Date());

		List<Payment> paied = new ArrayList<Payment>();
		paied.add(pay);

		// add both of this //
		pay.setUser(u);
		u.setPayment(paied);
		user.save(u);

		if (!u.getName().equals("ara")) {
			throw new RuntimeException();
		}

		OtherPayment oth = new OtherPayment(u.getUserId(), "true");
		othpay.save(oth);
		// an(u);
		return "paied";

	}

	/*
	 * an(u) propagation=required --> It will be omit the child Transactional
	 * connection will be same for Parent and child propagation=required new --> It
	 * will be create a new connection when the an() is commit and then only
	 * saveData() method will be commit For this parent should not have forgin key
	 * mapping
	 */

	@Transactional // It will be omited because Parent @Transactional , and propagation it will
					// requried by default
	public void an(Users u) {
		OtherPayment oth = new OtherPayment(u.getUserId(), "true");
		othpay.save(oth);
	}

	public void testMapper(ModalDTO modalDTO) {
		System.out.println(modalDTO);
		Users userData = mapper.toUser(modalDTO);
		System.out.println(userData.toString());
		
		 // Map AddressDTOs to Address entities and set the Employee reference
        List<Payment> payments = modalDTO.getPayment().parallelStream() //.stream()
                .map(addressDTO -> {
                	Payment payment = mapper.toPayment(addressDTO);
                	payment.setCreateOn(new Date());
                //	address.setUpdateOn(null)
                	payment.setUser(userData);
                    return payment;
                })
                .collect(Collectors.toList());
		
		userData.setPayment(payments);
		
		user.save(userData);

	}

}
