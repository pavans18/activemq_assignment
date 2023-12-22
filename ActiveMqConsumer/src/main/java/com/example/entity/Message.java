package com.example.entity;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
	
	@NotEmpty(message = "User name is not entered, Enter User name")
	private String name;
	
	@NotEmpty(message = "User age is not entered, Enter User age")
	private int age;
	
	@NotEmpty(message = "User email is not entered, Enter User email")
	private String email;
	
	

}
