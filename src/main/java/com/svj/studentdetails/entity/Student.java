package com.svj.studentdetails.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Student {
	
	private int studentId;
	private String firstName;
	private String lastName;
	private LocalDate date;
	private String gender;
	private String grade;
	private String contactNo;
	private String email;
	private String address;
	private String emergencyContact;

}
