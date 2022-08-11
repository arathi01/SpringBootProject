package com.ait.CustomerService.entity;

import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="customer_id")
	private Long id;
	private String customerName;
	private String address;
	
	  @ManyToMany
	    @JoinTable(name = "customer_product",
	            joinColumns = @JoinColumn(name = "customer_id"),
	            inverseJoinColumns = @JoinColumn(name = "product_id"))
	    private List<Product> products;
	  

	public Customer() {
		super();
	}
	


	public Customer(String customerName, String address) {
		super();
		this.customerName = customerName;
		this.address = address;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", customerName=" + customerName + ", address=" + address + ", products="
				+ products + "]";
	}
	  

}
