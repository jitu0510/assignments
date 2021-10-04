package com.hibernate.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="student_details")
public class Student implements Serializable {
	@Id
	private int rollno;
	private String name;
	private int phoneno;
	private String standard;
	

}
