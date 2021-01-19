package tn.enis.member.entities;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@DiscriminatorValue("teacher")

public class Teacher extends Member {
	String grade;
	String etablissement;
	@OneToMany(mappedBy = "teacher")
	@JsonIgnore
	private List<Student> students;
}
