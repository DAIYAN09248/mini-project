package com.example.mini_project.model;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Data
@Document(collection = "recharges")
public class Recharge {
    @Id
    private String id;
    
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@NotBlank(message = "Member ID is required")
    private String memberId;
    
    @NotNull(message = "Date & time is required")
    private Date dateTime;
    
    @DecimalMin(value = "100.01", message = "Amount must be greater than 100")
    @DecimalMax(value = "1999.99", message = "Amount must be less than 2000")
    private double amount;
}