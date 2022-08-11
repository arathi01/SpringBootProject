package com.ait.CustomerService.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ait.CustomerService.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	

//	void deleteCustomer(Long id);


}
