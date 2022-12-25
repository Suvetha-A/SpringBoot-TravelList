package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Travel {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int id;
	private int Travelid;
	private String name,description;
	
	  Travel() {}

	  Travel(int Travelid,String name,String description){
		  this.setTravelid(Travelid);
		  this.setName(name);
		  this.setDescription(description);
	  }

	public int getTravelid() {
		return Travelid;
	}
	public void setTravelid(int travelid) {
		Travelid = travelid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
