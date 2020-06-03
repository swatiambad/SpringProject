package com.javabykiran.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.javabykiran.entity.User;
import com.javabykiran.service.SpringMvcService;

@Controller
public class SpringMvcController {
	@Autowired
	SpringMvcService mvcservice;
	
@RequestMapping("/loginpage")	
public String OpenloginPage() {
	return "login";
}
 @RequestMapping("/login")
 public ModelAndView checkloginpage(@ModelAttribute User user) {
	 //@modelattribute
	 System.out.println(user.getUsername());
	 System.out.println(user.getName());
	 //login.jsp-->servlet_class
	 //deget(req,res)
	 //String  username=request.getparametr("username")
	 
	 ModelAndView mv=new ModelAndView();
	 
	boolean result= mvcservice.checkloginpage(user);
	if(result) {
		 mv.setViewName("redirect:/home");
	}
	else {
		 mv.setViewName("login");
	}
	
	 return mv;
 }
	 //servlet jsp
	  //page navigation dispatcher
	 @RequestMapping("/home")
	 public ModelAndView openhomepage() {
		 ModelAndView mv=new ModelAndView();
		 List<User> listuser=mvcservice.getuser();
		 if(!listuser.isEmpty()) {
			 mv.addObject("list", listuser);
			 mv.setViewName("home");
		 }
		 else {
			 mv.addObject("msg", "something went wrong");
			 mv.setViewName("login");
		 }
		 return mv;
		 
	 }
	 
	 @RequestMapping("/deleteuser")
	  public ModelAndView deleteUser(@RequestParam("id") String id) {
		 ModelAndView mv=new ModelAndView();
			int userid=Integer.parseInt(id);
			System.out.println(userid);
			//mvcservice.deleteUser(userid);
			if(mvcservice.deleteUser(userid))
			{
				 List<User> listuser=mvcservice.getuser();
				 mv.addObject("list", listuser);
				 mv.setViewName("home");
				//mv.addObject("msg", "User deleted Successfully!");
				
			}
		else {
			mv.addObject("msg"," sometbin went wrong");
		}
		return mv;
		 
	 }
	 
	 @RequestMapping("/updateuser")
	 public ModelAndView getUser(@RequestParam("id") String id) {
		 ModelAndView mv=new ModelAndView();
		 int userid=Integer.parseInt(id);
		List<User> listuser= mvcservice.getUser(userid);
		if(!listuser.isEmpty()) {
			mv.addObject("list", listuser);
			mv.setViewName("updateuser");
		}
		else {
			mv.addObject("msg", "something went wrong");
			mv.setViewName("home");
		}
		
		return mv;
	 }
	 
	 @RequestMapping("/updateparticularuser")
	 public ModelAndView updateuser(@ModelAttribute User user) {
		 ModelAndView mv=new ModelAndView();
		 if(mvcservice.updateuser(user)) {
			List<User>listuser= mvcservice.getuser();
			mv.addObject("list", listuser);
			mv.setViewName("home");
		 }
		 else {
			 mv.addObject("msg", "something went wrong");
				mv.setViewName("home");
		 }
		 return mv;
		 
	 }
	 
	 
	 @RequestMapping("/adduserpage")
	 public String openadduser()
	 {
		 return "adduser";
	 }
	 
	 @RequestMapping("/adduser")
	 public ModelAndView adduser(@ModelAttribute User user) {
		 System.out.println("user"+user);
         ModelAndView mv=new ModelAndView();
         boolean result=mvcservice.adduser(user);
         if(result)
         {
	         mv.addObject("msg", "record inserted successfully");
	          List<User> listuser=mvcservice.getuser();
	          mv.addObject("list", listuser);
	         mv.setViewName("home");
        }
     else 
     {
	       mv.addObject("msg", "something went wrong");
	        mv.setViewName("home");
      }
   return mv;
	
	 }
	
	 
	 
 }

