package com.example.mini_project.model;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "games")
public class Game {
    @Id
    private String id;
    
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getMinPlayCount() {
		return minPlayCount;
	}

	public void setMinPlayCount(int minPlayCount) {
		this.minPlayCount = minPlayCount;
	}

	public int getMaxPlayCount() {
		return maxPlayCount;
	}

	public void setMaxPlayCount(int maxPlayCount) {
		this.maxPlayCount = maxPlayCount;
	}

	public int getMultiPlayCount() {
		return multiPlayCount;
	}

	public void setMultiPlayCount(int multiPlayCount) {
		this.multiPlayCount = multiPlayCount;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@NotBlank(message = "Game name is required")
    private String name;
    
    @DecimalMin(value = "0.01", message = "Price must be greater than 0")
    private double price;
    
    private String description;
    
    @Min(value = 1, message = "Duration must be at least 1 minute")
    private int duration;
    
    @Min(value = 1, message = "Min play count must be at least 1")
    private int minPlayCount;
    
    @Min(value = 1, message = "Max play count must be at least 1")
    private int maxPlayCount;
    
    @Min(value = 1, message = "Multi play count must be at least 1")
    private int multiPlayCount;
    
    @NotNull(message = "Status is required")
    private boolean active;
}