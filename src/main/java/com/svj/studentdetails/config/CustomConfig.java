package com.svj.studentdetails.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomConfig {
	
	@Bean
	ModelMapper modeMapper() {
		
		return new ModelMapper();
	}

}
