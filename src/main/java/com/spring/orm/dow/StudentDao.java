package com.spring.orm.dow;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.spring.orm.entity.Student;

public class StudentDao {
	
	
	private HibernateTemplate hibernateTemplate;
    //Save student
	@Transactional
	public int insert(Student student) {
		//Insert
	Integer i=(Integer)	this.hibernateTemplate.save(student);
		return i;
	}
	//get the single data
	public Student getStudent(int studentId) {
		Student student = this.hibernateTemplate.get(Student.class,studentId);
		
		return student;
		
	}
	//get all students (all rows)
	
	public List<Student> getAllStudents() {
		List<Student> students = this.hibernateTemplate.loadAll(Student.class);
		return students;
	}
	
	//deleating the data
	@Transactional
	public void deleteStudent(int studentId) 
	{
		Student student = this.hibernateTemplate.get(Student.class, studentId);
	 this.hibernateTemplate.delete(student);
	}
	
	//Updating data
	@Transactional
	public void updateStudent(Student student) {
		this.hibernateTemplate.update(student);
	}
	
	
	
	private Serializable studentId() {
		// TODO Auto-generated method stub
		return null;
	}
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
}
