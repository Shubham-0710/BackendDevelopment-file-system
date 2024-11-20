package com.svj.studentdetails.exceptionhandler;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.svj.studentdetails.exception.AlreadyExistException;
import com.svj.studentdetails.exception.ResourceNotFoundException;
import com.svj.studentdetails.response.ApiResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;


@RestControllerAdvice
public class ExceptionController {
	
    @ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> handleException(ResourceNotFoundException e){
		
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Student Not Found",null));
    			
		
	}
	
    
    @ExceptionHandler(Exception.class)
  	public ResponseEntity<ApiResponse> handleException(Exception e){
  		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      			
  		
  	}
	
    @ExceptionHandler(AlreadyExistException.class)
  	public ResponseEntity<ApiResponse> handleException(AlreadyExistException e){
  		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      			
  		
  	}

}
