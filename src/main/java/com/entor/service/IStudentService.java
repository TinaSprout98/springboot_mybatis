package com.entor.service;

import java.util.List;

import com.entor.entity.Student;

public interface IStudentService{
	
	public Student queryById(String id);
	
	public List<Student> queryByPage(int currentPage,int pageSize);
	
	public void add(Student student);
	
	public void deleteById(int id);
	
	public void deleteMore(String id);
	
	public List<Student> queryAll();
}
