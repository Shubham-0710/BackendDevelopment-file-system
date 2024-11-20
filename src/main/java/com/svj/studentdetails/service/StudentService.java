package com.svj.studentdetails.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.svj.studentdetails.dto.StudentDto;
import com.svj.studentdetails.entity.Student;
import com.svj.studentdetails.exception.AlreadyExistException;
import com.svj.studentdetails.exception.ResourceNotFoundException;
import com.svj.studentdetails.filesystem.FileSystem;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService implements IStudentService {

    private final FileSystem fileSystem;
    private final ModelMapper modelMapper;

	@Override
	public StudentDto getStudentById(int id) throws ResourceNotFoundException, IOException {
	
			List<Student> list = fileSystem.read();
			Student student = list.stream().filter(stud->stud.getStudentId()==id).findFirst().orElseThrow(()-> new ResourceNotFoundException("Student not Found"));
			
			return modelMapper.map(student,StudentDto.class);

	}

	@Override
	public StudentDto addStudent(StudentDto studentDto) throws IOException, AlreadyExistException {
		
			List<Student> list = fileSystem.read();
			
			Optional<Student> optional = list.stream().filter(student->student.getStudentId()==studentDto.getStudentId()).findFirst();
			
			if(optional.isEmpty()) {
				Student student = modelMapper.map(studentDto,Student.class);
				
			list.add(student);
			
			fileSystem.write(list);
			
			return studentDto;
			
			}else {
				
				throw new AlreadyExistException("Duplicate entry");
			}
		
	}

	@Override
	public StudentDto updateStudent(StudentDto studentDto, int id) throws ResourceNotFoundException, IOException {
	
		List<Student> list = fileSystem.read();
		
		Student studentF =	list.stream().filter(stud->stud.getStudentId()==id).findFirst().orElseThrow(()-> new ResourceNotFoundException("Student not Found"));

		List<Student> listUpdate = list.stream().filter(student-> student.getStudentId()!=studentF.getStudentId()).toList();
		
		list.clear();
		list.addAll(listUpdate);
		
		list.add(modelMapper.map(studentDto,Student.class));
		
		fileSystem.write(list);
		
		return studentDto;
		
	}

	@Override
	public void removeStudent(int id) throws ResourceNotFoundException, IOException {
		
        List<Student> list = fileSystem.read();
		
		Student studentF = list.stream().filter(stud->stud.getStudentId()==id).findFirst().orElseThrow(()-> new ResourceNotFoundException("Student not Found"));

		List<Student> listUpdate = list.stream().filter(student-> student.getStudentId()!=studentF.getStudentId()).toList();
		
		
		fileSystem.write(listUpdate);

	} 


}
