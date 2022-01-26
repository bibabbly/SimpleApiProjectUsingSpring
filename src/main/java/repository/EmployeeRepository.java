package repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import model.Employee;



@Mapper
public interface EmployeeRepository {
	
	@Insert("INSERT INTO users(FIRSTNAME,LASTNAME,PHONE,PWD)"
			+ "VALUES(#{firstName},#{lastName},#{mobilePhone},#{password})")
	int insert(Employee employee);
	@Select("SELECT * FROM EMPLOYEE")
	List<Employee> findAll();
	
	@Select("SELECT PHONE,PWD FROM users where MOBILEPHONE = #{mobilePhone}")
	Employee  selectByPhone(@Param("mobilePhone") String mobilePhone);
	
	

}
