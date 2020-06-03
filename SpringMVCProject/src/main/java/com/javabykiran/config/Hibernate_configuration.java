package com.javabykiran.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.javabykiran.entity.User;

@Configuration
@EnableWebMvc
public class Hibernate_configuration {
	@Autowired
ApplicationContext context;
	@Bean
	public LocalSessionFactoryBean getbean() {
		System.out.println("hibernate_configuration--getbean()");
		LocalSessionFactoryBean factorybean=new LocalSessionFactoryBean();
		factorybean.setConfigLocation(context.getResource("classpath:hibernate.cfg.xml"));
		factorybean.setAnnotatedClasses(User.class);
		return factorybean;
	}
}
