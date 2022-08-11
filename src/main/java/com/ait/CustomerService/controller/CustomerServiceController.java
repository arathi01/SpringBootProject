package com.ait.CustomerService.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ait.CustomerService.entity.Customer;
import com.ait.CustomerService.exceptions.ResourceNotFoundException;
import com.ait.CustomerService.repository.CustomerRepository;





@RestController
public class CustomerServiceController {
	
	@Autowired
	private CustomerRepository customerRepository;

	 @GetMapping("/customer")
	    public List<Customer> getCustomers() {
	        return customerRepository.findAll();
	    }
	   @GetMapping("/customers/{id}")
	    public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "id") Long customerId) throws ResourceNotFoundException {
	        Optional<Customer> customer = customerRepository.findById(customerId);
	        if(customer.isPresent())
	            return ResponseEntity.ok().body(customer.get());
	        else
	            throw new ResourceNotFoundException("customer not found :: " + customerId);
	    }

	    @PostMapping("/customers")
	    public Customer createCustomer(@RequestBody Customer customer) {
	        return customerRepository.save(customer);
	    }
	    
//		@RequestMapping(value = "/{id}", method = RequestMethod.GET)
//		public Optional<Customer> getCustomerId(@PathVariable Long id)
//		{
//			return customerRepository.getCustomerById(id);
//		}
//		
//		@DeleteMapping(path = "{id}")
//		public void deleteCustomer(@PathVariable("id") Long id) {
//			customerRepository.deleteCustomer(id);
//		}
}
