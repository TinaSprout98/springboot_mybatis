package com.entor.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entor.entity.Student;
import com.entor.mapper.StudentMapper;
import com.entor.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService{

	@Autowired
	private StudentMapper sm;
	
	public Student queryById(String id) {
		return sm.queryById(id);
	}
	
	
	public List<Student> queryByPage(int currentPage,int pageSize){
		return sm.queryByPage(currentPage, pageSize);
	}
	
	
	public void add(Student student) {
		sm.add(student);
	}
	
	
	public void deleteById(int id) {
		sm.deleteById(id);
	}

	
	public void deleteMore(String ids) {
		sm.deleteMore(ids);
		
	}

	@Override
	public List<Student> queryAll() {
		return sm.queryAll();
	}
}
