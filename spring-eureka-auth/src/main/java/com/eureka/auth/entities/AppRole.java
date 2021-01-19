package com.eureka.auth.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AppRole {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String roleName;
	
}
