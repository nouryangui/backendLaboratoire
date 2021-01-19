package tn.enis.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import tn.enis.member.bean.EventBean;
import tn.enis.member.bean.PublicationBean;
import tn.enis.member.bean.ToolBean;
import tn.enis.member.dao.MemberRepository;
import tn.enis.member.entities.Member;
import tn.enis.member.entities.Student;
import tn.enis.member.entities.Teacher;
import tn.enis.member.service.IMemberService;

@RestController
@RequestMapping("/api/members")
@Slf4j

public class MemberController {
	@Autowired
	IMemberService memberService;
	@Autowired
	MemberRepository memberRepository ;

	@PostMapping(value = "/students")
	public Member addStudent(@RequestBody Student student) {
		return memberService.add(student);
	}

	@PostMapping(value = "/teachers")
	public Member addTeacher(@RequestBody Teacher teacher) {
		return memberService.add(teacher);
	}

	@GetMapping()
	public List<Member> findAllMembres() {
		return memberService.findAll();
	}

	@GetMapping(value = "/all")
	public Page<Member> findAllMembersPaginator(@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		return memberService.getAll(PageRequest.of(page, size));
	}

	@GetMapping(value = "/teachers")
	public List<Teacher> findAllTeachers() {
		return memberService.findAllTeachers();
	}

	@GetMapping(value = "/count")
	public Long findCountMembers() {
		return memberRepository.count();
	}

	@GetMapping(value = "/students")
	public List<Student> findAllStudents() {
		return memberService.findAllStudents();
	}

	@GetMapping(value = "{id}")
	public Member findoneMembre(@PathVariable Long id) {

		return memberService.getById(id);

	}

	@PutMapping(value = "/students")
	public Student updateStudent(@RequestBody Student student) {
		return (Student) memberService.update(student);

	}

	@PutMapping(value = "/teachers")
	public Member updateTeacher(@RequestBody Teacher teacher) {
		return memberService.update(teacher);

	}

	@DeleteMapping(value = "{id}")
	public void DeleteMember(@PathVariable Long id) {
		memberService.delete(id);

	}

	@GetMapping(value = "/grade/{grade}")

	public List<Teacher> findteacherByGrade(@PathVariable String grade) {

		return (List<Teacher>) memberService.findByGrade(grade);

	}

	@GetMapping(value = "/etablissement/{etablissement}")

	public List<Teacher> findteacherByetablissement(@PathVariable String etablissement) {

		return (List<Teacher>) memberService.findByEtablissement(etablissement);

	}

	@PostMapping("/students/{idStudent}/{idTeacher}")
	public Student affectTeacher(@PathVariable Long idStudent, @PathVariable Long idTeacher) {
		return memberService.affectTeacher(idTeacher, idStudent);
	}

	@GetMapping("/fullmember/{id}")
	public Member findFullMember(@PathVariable(name = "id") Long id) {

		Member member = memberService.getById(id);
		member.setPublications(memberService.findPublicationByMember(id));
	member.setTools(memberService.findToolByMember(id));
		member.setEvents(memberService.findEventByMember(id));

		return member;

	}

	@PostMapping("/publications/{idMember}/{idPublication}")
	public void affectMemberToPublication(@PathVariable Long idMember, @PathVariable Long idPublication) {
		memberService.affectMemberToPublication(idMember, idPublication);
	}

	@PostMapping("/tools/{idMember}/{idTool}")
	public void affectMemberToTool(@PathVariable Long idMember, @PathVariable Long idTool) {
		memberService.affectMemberToTool(idMember, idTool);
	}

	@PostMapping("/events/{idMember}/{idEvent}")
	public void affectMemberToEvent(@PathVariable Long idMember, @PathVariable Long idEvent) {
		memberService.affectMemberToEvent(idMember, idEvent);
	}

	@GetMapping("/tools/{idMember}")
	public List<ToolBean> findToolByMember(@PathVariable Long idMember) {
		return memberService.findToolByMember(idMember);
	}

	@GetMapping("/events/{idMember}")
	public List<EventBean> findEventByMember(@PathVariable Long idMember) {
		return memberService.findEventByMember(idMember);
	}
	@GetMapping("/publications/{idMember}")
	public List<PublicationBean> findPublicationByMember(@PathVariable Long idMember) {
		return memberService.findPublicationByMember(idMember);
	}
	@GetMapping("/event/{idEvent}")
	public List<Member> findMemberByEvent(@PathVariable Long idEvent) {
		return memberService.findMemberByEvent(idEvent);
	}

}
