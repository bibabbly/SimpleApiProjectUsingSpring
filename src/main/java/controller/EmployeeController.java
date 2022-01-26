package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import model.Employee;
import service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired private EmployeeService employeeService;
//	@Autowired private BCryptPasswordEncoder encoder;

	 @GetMapping("/")
	 public String user(){
//		 model.addAttribute("listUser",userServices.getAllUsers());
			return "login";
	 }
	 
	 @GetMapping("/register")
	 public String registerPage(){
//		 model.addAttribute("listUser",userServices.getAllUsers());
			return "register";
	 }
	 
	 @GetMapping("/user-list")
		public String getUsers(Model model){
			model.addAttribute("listUser",employeeService.getAllUsers());
			return "index";
		}
	 
		@RequestMapping(value = { "/insert-user" }, method = RequestMethod.POST)
		@ResponseBody
		public RedirectView addUser(Employee emplo){

			
			employeeService.save(emplo);
			return new RedirectView("/");
		}
		
		@RequestMapping(value = { "/user-login" }, method = RequestMethod.POST)
		@ResponseBody
		public RedirectView loginUser(Employee emplo,Model model){
			String username = emplo.getMobilePhone();
			String passwordCome = emplo.getPassword();
			//check if password is correct or not
			
			System.out.println("username"+username);
			System.out.println("password"+passwordCome);
			 Employee userGet = employeeService.getUserbyid(username,passwordCome);
			 if(userGet!=null){
				 String phoneNumber = userGet.getMobilePhone();
		    	 String password = userGet.getPassword();
		    	 BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();  
		    	 ;
		    	// if(phoneNumber.equals(username) && encoder.matches(passwordCome,password)){
		    	 if(phoneNumber.equals(username) && password.equals(passwordCome)){
		    		 
		    		 return new RedirectView("/user-list");
		    	 }
		    	 else {
//		    		return result to the screen
		    		String error ="Your username and password is invalid.";
		    		 model.addAttribute("error",error);
		    		 return new RedirectView("/");
		    	 }
			 }
			 return new RedirectView("/");
	    	 
		}
		
		
		
}
