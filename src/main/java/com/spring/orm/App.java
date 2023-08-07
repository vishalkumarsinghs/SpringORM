package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dow.StudentDao;
import com.spring.orm.entity.Student;

public class App 
{
    public static void main( String[] args )
    {
     ApplicationContext context= new ClassPathXmlApplicationContext("confi.xml");
    
     StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
//   Student student= new Student(464,"Sweety singh","Gopalganj");
//   
//   int r = studentDao.insert(student);
//   System.out.println("Done"+r);
     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
   boolean go=true;
     while(go) {
     System.out.println("PRESS 1 for add student");
     System.out.println("PRESS 2 for display all students");
     System.out.println("PRESS 3 for get deteail of single student");
     System.out.println("PRESS 4 for delete students");
     System.out.println("PRESS 5 for update students");
     System.out.println("PRESS 6 for exit");
    
     try {
    	 
    	 int input=Integer.parseInt(br.readLine());
    switch(input) {
    
    case 1:
    	//add a new student
    	// taking inputs from user
    	System.out.println("Enter user id: ");
    	int uId= Integer.parseInt(br.readLine());
    	
    	System.out.println("Enter user name: ");
    	String uName=br.readLine();
    	
    	System.out.println("Enter user city : ");
    	String uCity=br.readLine();
    	
    	//creating student object and setting values
    	
    	Student s=new Student();
    	s.setStudentId(uId);
    	s.setStudentName(uName);
    	s.setStudentCity(uCity);
    	
    	//saving student object to database by calling insert of student daw
    	
    	int r = studentDao.insert(s);
    	System.out.println(r + "student added");
    	System.out.println("********************************");
    	System.out.println();
    	
    	break;
    	
    case 2:
    	//display all student
    	List<Student> allStudents = studentDao.getAllStudents(); 
    	for (Student st: allStudents) {
    		System.out.println("Id : " + st.getStudentId());
    		System.out.println("Name : "+ st.getStudentName());
    		System.out.println("City :" + st.getStudentCity());
    		System.out.println("*****************************");
    		
    	}
    	System.out.println("------------------------------");
    	break;
    	
    case 3:
    	//get single student data
    	System.out.println("Enter user id: ");
    	int userId= Integer.parseInt(br.readLine());
    	Student student = studentDao.getStudent(userId);
    	
    	System.out.println("Id : " + student.getStudentId());
		System.out.println("Name : "+ student.getStudentName());
		System.out.println("City :" + student.getStudentCity());
		System.out.println("*****************************");
    	  	
    	break;
    	
    case 4:
    	// delete student
    	System.out.println("Enter user id: ");
    	int id= Integer.parseInt(br.readLine());
    	studentDao.deleteStudent(id);
    	System.out.println("Student deleted sucessfully...");
    	break;
    	
   case 5:
   //   	update the students
	   
		System.out.println("Enter the student id to be updated");
		int updatedId = Integer.parseInt(br.readLine());
		
		System.out.println("Press 1 for update the name");
		System.out.println("Press 2 for update the city\n");
		
		System.out.println("Enter your choise for what do you want to update?");
		int choice = Integer.parseInt(br.readLine());
		
		Student std1 = studentDao.getStudent(updatedId);
		
		String updatedName = std1.getStudentName();
		String updatedCity = std1.getStudentCity();
		
    	switch (choice)
		{
		case 1:
			System.out.println("Enter the name to be updated");
			updatedName = br.readLine();
			//setting the student objects value
			std1 = new Student(updatedId, updatedName, updatedCity);
		System.out.println("Name updated successfully");		
	   break;

		case 2:
			System.out.println("Enter the city name to be updated");
			updatedCity = br.readLine();
			//setting the student objects value in another way
				std1.setStudentId(updatedId);
				std1.setStudentName(updatedName);
				std1.setStudentCity(updatedCity);		
				System.out.println("City updated successfully");
			break;
		}
		
		studentDao.updateStudent(std1);
		System.out.println("Updated successfully\n");
		
   	break;
    	
    case 6:
    //exit
    go=false;
    break;
    
    }
     
     }catch(Exception e) {
     System.out.println("Invild Input try with anoythr one !!");
     System.out.println(e.getMessage());
     }  
   }
   //  System.out.println("Thankyou (user) using my application");
     //System.out.println("See you soon");
} 
}
