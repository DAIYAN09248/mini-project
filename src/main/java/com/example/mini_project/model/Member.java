package com.example.mini_project.model;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Data
@Document(collection = "members")
public class Member {
    @Id
    private String id;
    
    @NotBlank(message = "Name is required")
    private String name;
    
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	@Pattern(regexp = "^\\d{10}$", message = "Phone number must be 10 digits")
    private String phoneNo;
    
    @Min(value = 1, message = "Age must be at least 1")
    @Max(value = 120, message = "Age must be less than 120")
    private int age;
    
    @DecimalMin(value = "0.01", message = "Balance must be greater than 0")
    @DecimalMax(value = "9999.99", message = "Balance must be less than 10000")
    private double balance;
    
    @NotNull(message = "Joining date is required")
    private Date joiningDate;
}