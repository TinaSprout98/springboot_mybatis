package com.entor.contorller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entor.entity.Student;
import com.entor.service.IStudentService;

@RestController
public class StudentController {
	
	@Autowired
	public IStudentService is;
	
	@RequestMapping("/queryById")
	public Student queryById(String id) {
		return is.queryById(id);
	}
	
	@RequestMapping("/queryByPage")
	public List<Student> queryByPage(int currentPage,int pageSize) {
		return is.queryByPage(currentPage, pageSize);
	}
	
	@RequestMapping("/add")
	public void add(Student student) {
		Student s = new Student();
		s.setName("aaa");
		s.setUsernaame("aaa");
		s.setPassword("123456");
		s.setSex(0);
		s.setAge(18);
		s.setBirthday(new Date());
		s.setCreateTime(null);
		is.add(student);
	}
	
	@RequestMapping("/deleteById")
	public void deleteById(int id) {
		is.deleteById(id);
	}
	
	@RequestMapping("/deleteMore")
	public void deleteMore(String ids) {
		is.deleteMore(ids);
	}
	
	@RequestMapping("/queryAll")
	public List<Student> queryAll(){
		return is.queryAll();
		
	}
}
