package com.svj.studentdetails.filesystem;

import java.io.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.svj.studentdetails.entity.Student;

@Repository
public class FileSystem {
	
	private String studentFile="StudentDataFile.json";
	
	private ObjectMapper objectMapper= new ObjectMapper().registerModule( new JavaTimeModule());
	
	public void write(List<Student>studentList) throws IOException {
		
		File file= new File(studentFile);
		objectMapper.writeValue(file , studentList);
		
	}
	
	public List<Student> read() throws IOException{
	
		File file= new File(studentFile);
		
		if(file.length()==0) {
			return new ArrayList<>(List.of());
		}
		
		CollectionType collectionType = objectMapper.getTypeFactory().constructCollectionType(List.class, Student.class);
		return objectMapper.readValue(file,collectionType);
		
	}
		
    
}
