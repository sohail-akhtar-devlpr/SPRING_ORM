package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.persistence.criteria.CriteriaBuilder.Case;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.FileSystemUtils;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
    
        ApplicationContext context=
        		new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao=context.getBean("studentDao",StudentDao.class);
		/*
		 * Student student=new Student(167,"Akbar","Hyderabad"); int
		 * res=studentDao.insert(student); System.out.println("Done "+res);
		 */
        
        //GOING TO CREATE A CONSOLE BSED APPLICATION TO PERFORM CRUD OPERATION
        //1.FOR ADD
        //2.DELETE...ETC
        
        //FIRST CREATE A BUFFERED READER OBJECT
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("PRESS 1. TO ADD");
        System.out.println("PRESS 2. TO DISPLAY ALL STUDENTS");
        System.out.println("PRESS 3. TO GET SINGLE STUDENT DETAIL");
        System.out.println("PRESS 4. TO DELETE");
        System.out.println("PRESS 5. TO UPDATE STUDENT");
        System.out.println("PRESS 6. TO EXIT");
        
        boolean go=true;
        while(go) {
        	try {
        		int input=Integer.parseInt(br.readLine());
				switch(input){
					case 1:
						// add student detail
						//I HAVE TO PASS Student Object
						System.out.println("enter student id");
						int studentID=Integer.parseInt(br.readLine());
						System.out.println("enter student name");
						String studentName=br.readLine();
						System.out.println("enter student city");
						String studentCity=br.readLine();
						
						Student student=new Student();
						student.setStudentID(studentID);
						student.setStudentName(studentName);
						student.setCity(studentCity);
						
						//now use the StudentDao object to save the details of the student;
						int r=studentDao.insert(student);//returns itegral value that is no.of rows effected
						System.out.println(r+" student added");
						System.out.println("successfully added");
						break;
						
					case 2:
						//display all students
						System.out.println("***********************************************");
						List<Student> allStudent=studentDao.getAllStudent();
						for(Student s:allStudent) {
							System.out.println("ID: "+s.getStudentID());
							System.out.println("naem: "+s.getStudentName());
							System.out.println("city: "+s.getCity());
						}
						System.out.println("*************************************************");
						break;
						
					case 3:
						//get single student details
						System.out.println("enter student id");
						int studID=Integer.parseInt(br.readLine());
						Student stud = studentDao.getStudent(studID);
						System.out.println("ID: "+stud.getStudentID());
						System.out.println("naem: "+stud.getStudentName());
						System.out.println("city: "+stud.getCity());
						break;
					case 4:
						//delete student id
						System.out.println("enter student id");
						int delStudID=Integer.parseInt(br.readLine());
						studentDao.deleteStudent(delStudID);
						System.out.println("Student deleted successfully");
						break;
					case 5:
						//update student details
						break;
					case 6:
						go=false;
						break;
				}
			} catch (Exception e) {
				System.out.println("Invalid input..try with another");
				System.out.println(e.getMessage());
			}
        }
        System.out.println("Thank you using my application");
    }
}
