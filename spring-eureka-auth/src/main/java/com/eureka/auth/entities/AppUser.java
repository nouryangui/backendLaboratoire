package com.eureka.auth.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@Column(unique = true)
	String username;
	//ne pas retourner le password(get)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	String password;
	@ManyToMany(fetch = FetchType.EAGER)
	List<AppRole> roles = new ArrayList<>();
	String email;
	

}
