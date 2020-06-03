package com.javabykiran.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		System.out.println("Application Initializer--getServletConfigClasses()");
		 return new Class[] {Wencongiguration.class,Hibernate_configuration.class };	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("Application Initializer--getServletMappings");
		// TODO Auto-generated method stub
		 return new String[] { "/" };	}

}
