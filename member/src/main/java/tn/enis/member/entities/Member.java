package tn.enis.member.entities;

import java.io.File;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import tn.enis.member.bean.EventBean;
import tn.enis.member.bean.PublicationBean;
import tn.enis.member.bean.ToolBean;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@DiscriminatorColumn(name = "type_mbr", discriminatorType = DiscriminatorType.STRING)

public abstract class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@NonNull
	String cin;
	@NonNull
	String firstName;
	@NonNull
	String lastName;
    @JsonFormat(pattern="yyyy-MM-dd")
	LocalDate birthDate;
	@NonNull
	String email;
	@NonNull
	String password;
	Byte[] photo;
	
	File cv;
	@Transient
	List<PublicationBean> publications;
	@Transient
	List<ToolBean> tools;
	@Transient
	List<EventBean> events;
}
