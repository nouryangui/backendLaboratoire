package tn.enis.member.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.enis.member.entities.Member;
@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {

	Member findByCin(String cin);

	Member findByEmail(String email);
	

}