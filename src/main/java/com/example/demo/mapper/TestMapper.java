package com.example.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import com.example.demo.entity.Payment;
import com.example.demo.entity.Users;
import com.example.demo.modalDTO.ModalDTO;
import com.example.demo.modalDTO.PaymentDTO;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TestMapper {

	TestMapper INSTANCE = Mappers.getMapper(TestMapper.class);
	
	@Mapping(target = "id", ignore = true) 
    Users toUser(ModalDTO userDTO);

   @Mapping(target = "user", ignore = true) // Ignore the user mapping as it's handled separately
  @Mapping(target = "id", ignore = true) 
   Payment toPayment(PaymentDTO paymentDTO);

   @Mapping(target = "id", ignore = true) 
   void updateUsersFromDto(ModalDTO employeeDetails, @MappingTarget Users employee);

   @Mapping(target = "id", ignore = true) 
   void updatePaymentFromDto(PaymentDTO addressDTO, @MappingTarget Payment address);

   List<Payment> toPaymentList(List<PaymentDTO> addressDTOList);
	
}
