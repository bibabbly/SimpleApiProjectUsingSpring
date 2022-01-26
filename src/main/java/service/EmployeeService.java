package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import model.Employee;
import repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired private EmployeeRepository employeeRepo;
	@Autowired private BCryptPasswordEncoder encoder;
	
	  public List<Employee> getAllUsers(){
	    	return employeeRepo.findAll();
	    } 
	  
	    public void save(Employee employee){
	    	employee.setPassword(encoder.encode(employee.getPassword()));
	    	employeeRepo.insert(employee);
	    }
	    
	    public Employee getUserbyid(String mobile,String password){
	    	
//	    	user.setPassword(encoder.encode(user.getPassword()));
	    	//String passWordCome = password;
	    	String mobilephone =mobile;
	    	 Employee empOne = employeeRepo.selectByPhone(mobilephone);
	    	 return  empOne;
	    }

}
