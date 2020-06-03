package com.javabykiran.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.javabykiran")
public class Wencongiguration implements WebMvcConfigurer {
     @Bean
	public InternalResourceViewResolver getresolver() {
    	 System.out.println("webconfiguration getresolver()");
		InternalResourceViewResolver viewresolver=new InternalResourceViewResolver();
		viewresolver.setPrefix("/WEB-INF/pages/");
		viewresolver.setSuffix(".jsp");

		return viewresolver;
	}
}
