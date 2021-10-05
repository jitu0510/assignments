package com.hibernate.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.hibernate.bean.Employee;
import com.hibernate.bean.Student;

public class StudentDriver {

//to display all the data
public static void displayAll() {
	EntityManagerFactory factory=null;
	EntityManager manager=null;
	try {
		factory=Persistence.createEntityManagerFactory("emp1");
		manager=factory.createEntityManager();
		String findAll="from Student";
		Query query=manager.createQuery(findAll);
		List<Student> list=query.getResultList();
		System.out.println(list);
		System.out.println("----------------------------");
		for (Student student : list) {
			System.out.println(student);
		}
		
	}catch(Exception e)
	{
		//
	}finally {
		factory.close();
		manager.close();
	}
	
}

//To verify an Id
public static boolean verifyId(int id) {
	EntityManagerFactory factory=null;
	EntityManager manager=null;
	Student student=null;
	//EntityTransaction transaction=null;
	try {
		factory=Persistence.createEntityManagerFactory("emp1");
		manager=factory.createEntityManager();
		student=manager.find(Student.class,id);
		//System.out.println(student);
		
		
	}catch (Exception e) {
		//
	}finally {
		factory.close();
		manager.close();
		if(student==null)
			return false;
		else
			return true;
	}
	
	
	
}
//To Print one student details
public static void printData(int id)
{
	EntityManagerFactory factory=null;
	EntityManager manager=null;
	//EntityTransaction transaction=null;
	try {
		factory=Persistence.createEntityManagerFactory("emp1");
		manager=factory.createEntityManager();
		Student student =manager.find(Student.class,id);
		System.out.println(student);
		
	}catch (Exception e) {
		//
	}finally {
		factory.close();
		manager.close();
	}
}
//To set Student name
public static void setName(String name,int id)
{
	EntityManagerFactory factory=null;
	EntityManager manager=null;
	EntityTransaction transaction=null;
	try {
		factory=Persistence.createEntityManagerFactory("emp1");
		manager=factory.createEntityManager();
		Student student=manager.find(Student.class, id);
		
		student.setName(name);
		transaction=manager.getTransaction();
		transaction.begin();
		manager.persist(student);
		transaction.commit();
		
		//System.out.println(employee.getDesignation());
	}catch (Exception e) {
		//
	}finally {
		factory.close();
		manager.close();
	}
	
}
//To Set Student phone Number
public static void setPhone(int phoneno,int id)
{
	EntityManagerFactory factory=null;
	EntityManager manager=null;
	EntityTransaction transaction=null;
	try {
		factory=Persistence.createEntityManagerFactory("emp1");
		manager=factory.createEntityManager();
		Student student=manager.find(Student.class, id);
		
		student.setPhoneno(phoneno);
		transaction=manager.getTransaction();
		transaction.begin();
		manager.persist(student);
		transaction.commit();
		
		//System.out.println(employee.getDesignation());
	}catch (Exception e) {
		//
	}finally {
		factory.close();
		manager.close();
	}
	
}
//To Set Student Standard
public static void setStandard(String standard,int id)
{
	EntityManagerFactory factory=null;
	EntityManager manager=null;
	EntityTransaction transaction=null;
	try {
		factory=Persistence.createEntityManagerFactory("emp1");
		manager=factory.createEntityManager();
		Student student=manager.find(Student.class, id);
		
		student.setStandard(standard);
		transaction=manager.getTransaction();
		transaction.begin();
		manager.persist(student);
		transaction.commit();
		
		//System.out.println(employee.getDesignation());
	}catch (Exception e) {
		//
	}finally {
		factory.close();
		manager.close();
	}
	
}

//To set New Id
public static void setId(int newId,int id)
{
	EntityManagerFactory factory=null;
	EntityManager manager=null;
	EntityTransaction transaction=null;
	try {
		factory=Persistence.createEntityManagerFactory("emp1");
		manager=factory.createEntityManager();
		Student student=manager.find(Student.class, id);
		String name=student.getName();
		String standard=student.getStandard();
		int phoneNo=student.getPhoneno();
		
		Student student1 = new Student();
		student1.setName(name);
		student1.setRollno(newId);
		student1.setPhoneno(phoneNo);
		student1.setStandard(standard);
		
		
		transaction=manager.getTransaction();
		transaction.begin();
		
		manager.persist(student1);
		manager.remove(student);
		transaction.commit();
		
		
		//System.out.println(employee.getDesignation());
	}catch (Exception e) {
		e.printStackTrace();
	}finally {
		factory.close();
		manager.close();
	}
	
}
//To Delete a Student
public static void deleteStudent(int id)
{
	EntityManagerFactory factory=null;
	EntityManager manager=null;
	EntityTransaction transaction=null;
	//Employee employee=new Employee();
	try {
		factory=Persistence.createEntityManagerFactory("emp1");
		manager=factory.createEntityManager();
		transaction=manager.getTransaction();
		Student student=manager.getReference(Student.class, id);
		transaction.begin();
		manager.remove(student);
		transaction.commit();
		
	}catch(Exception e)
	{
		//
	}
}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean exit=false;
		do {
			
			System.out.println("Press 1 to see all data");
			System.out.println("Press 2 to see any particular data");
			System.out.println("Press 3 to update any particular data");
			System.out.println("Press 4 to delete data");
			System.out.println("Press 0 to Exit");
			System.out.println("Select one option: ");
			int option = scanner.nextInt();
			
			switch (option) {
			case 1:
				displayAll();
				break;
			case 2:
				System.out.println("Enter Id to get student information");
				int id=scanner.nextInt();
				boolean check = verifyId(id);
				if(check==true) {
					printData(id);
				}else {
					try {
					throw new IdNotFoundException("Entered Id is Invalid");
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}
				}
				
				break;	
			case 3:
				System.out.println("Enter Id to update student information");
				int id1=scanner.nextInt();
				boolean check1=verifyId(id1);
				String name=null;
				String standard=null;
				int newId=0;
				int phoneno=0;
				
				if(check1==true) {
					System.out.println("Do you want to update name(Y/N)");
					char nameOption=scanner.next().charAt(0);
					if(nameOption=='Y' || nameOption=='y') {
						System.out.println("Enter new name");
						name=scanner.next();
						setName(name, id1);
						
					}
					
					System.out.println("Do you want to update phone number(Y/N)");
					char phoneOption=scanner.next().charAt(0);
					if(phoneOption=='Y' || phoneOption=='y') {
						System.out.println("Enter new phone number");
						phoneno =scanner.nextInt();
						setPhone(phoneno,id1);
					}
					
					System.out.println("Do you want to update Standard(Y/N)");
					char standardOption=scanner.next().charAt(0);
					if(standardOption=='Y' || standardOption=='y') {
						System.out.println("Enter new standard");
						standard=scanner.next();
						setStandard(standard,id1);
					}
					
					System.out.println("Do you want to update Roll Number(Y/N)");
					char idOption=scanner.next().charAt(0);
					if(idOption=='Y' || idOption=='y') {
						System.out.println("Enter new Id");
						newId=scanner.nextInt();
						setId(newId,id1);
					}
					
				}else {
					try {
					throw new IdNotFoundException("Entered Id is Invalid");
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}
				}
				
				break;
			case 4:
				System.out.println("Enter Id to delete student information");
				int id2=scanner.nextInt();
				boolean check2=verifyId(id2);
				if(check2==true)
				{
					deleteStudent(id2);
				}else {
					try {
						throw new IdNotFoundException("Entered Id is Invalid");
						}catch(Exception e) {
							System.out.println(e.getMessage());
						}
				}
				break;
			case 0:
				System.out.println("Thank You.....!!!!");
				exit=true;
				
				break;
			default:
				System.out.println("Please select a valid option...!!!");
				break;
			}
		}while(!exit);

	}

}
