package Org.jsp.HospitalBranchApp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Branch {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	private String name;
	private String email;
	private String address;
	private long phone;
	private long pincode;
	private  String city;
	
	@ManyToOne
	@JoinColumn(name="hospital_id")
	@JsonIgnore
	private Hospital hospital;

}
