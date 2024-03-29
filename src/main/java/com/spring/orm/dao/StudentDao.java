package com.spring.orm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.Student;

//import jakarta.transaction.Transactional;

@Transactional
public class StudentDao {
	private HibernateTemplate hibernateTemplate;
	
	//adding or inserting the data
	public int insert(Student student) {
		Integer i=(Integer)this.hibernateTemplate.save(student);
		return i;
	}
	
	//get the single data(object)
	public Student getStudent(int studentID) {
		Student student=this.hibernateTemplate.get(Student.class, studentID);
		return student;
	}
	
	//get multiple data(object)
	
	public List<Student> getAllStudent()
	{
		List<Student> student=this.hibernateTemplate.loadAll(Student.class);
		return student;
	}
	
	//deleting the data
	@Transactional
	public void deleteStudent(int studentID) {
		//first get the object of the student(studentID) which is to be deleted
		Student student=this.hibernateTemplate.get(Student.class, studentID);
		this.hibernateTemplate.delete(student);
	}
	
	
	//when inserting or deleting or updating we need Transactional annotation
	//updating the data
	@Transactional
	public void update(Student student){
		this.hibernateTemplate.update(student);
	}
	
	/**
	 * @return the hibernateTemplate
	 */
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	/**
	 * @param hibernateTemplate the hibernateTemplate to set
	 */
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	
}
