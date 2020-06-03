package com.javabykiran.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javabykiran.dao.SpringMvcDao;
import com.javabykiran.entity.User;

@Service
public class SpringMvcService {
	@Autowired
 SpringMvcDao mvcdao;
 
	public boolean checkloginpage(User user) {
		// TODO Auto-generated method stub
		boolean result=mvcdao.checkloginpage(user);
		return result;
	}

	public List<User> getuser() {
		// TODO Auto-generated method stub
		List<User> listuser=mvcdao.getuser();
		return listuser;
	}

	public Boolean deleteUser(int userid) {
		// TODO Auto-generated method stub
		return mvcdao.deleteUser(userid);
	}

	public List<User> getUser(int userid) {
		// TODO Auto-generated method stub
		return (List<User>)mvcdao.getUser(userid);
	}

	public boolean updateuser(User user) {
		// TODO Auto-generated method stub
		return mvcdao.updateuser(user);
	}

	public boolean adduser(User user) {
		// TODO Auto-generated method stub
		boolean result=mvcdao.adduser(user);
		return result ;
	}

}
