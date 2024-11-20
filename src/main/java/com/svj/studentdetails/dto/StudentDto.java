package com.svj.studentdetails.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

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


