package com.luv2code.ecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="address")
@Getter
@Setter
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "state")
	private String state;	
	
	@Column(name = "street")
	private String street;	
	
	@Column(name = "zip_code")
	private String zip_code;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Order order;
}
