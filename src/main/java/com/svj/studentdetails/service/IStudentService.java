package com.svj.studentdetails.service;


import java.io.IOException;

import com.svj.studentdetails.dto.StudentDto;
import com.svj.studentdetails.exception.AlreadyExistException;
import com.svj.studentdetails.exception.ResourceNotFoundException;

public interface IStudentService {

	public StudentDto getStudentById(int id) throws ResourceNotFoundException, IOException;
	public StudentDto addStudent(StudentDto studentDto) throws IOException, AlreadyExistException;
	public StudentDto updateStudent(StudentDto studentDto, int id) throws ResourceNotFoundException, IOException;
	void removeStudent(int id) throws ResourceNotFoundException, IOException;
	
}
