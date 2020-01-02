package com.entor.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.entor.entity.Student;

public interface StudentMapper{
	
	@Select("select * from student where id = #{id}")
	public Student queryById(String id);
	
	@Select("select * from student")
	public List<Student> queryAll();
	
	@Select("select * from student limit #{currentPage},#{PageSize}")
	public List<Student> queryByPage(@Param("currentPage") int currentPage,@Param("PageSize") int pageSize);

	@Insert("insert into student(name,username,password,sex,age,birthday,createTime)values(#{name},#{username},#{passwpord},#{sex},#{age},#{brithday},#{createTime}))")
	public void add(Student student);
	
	@Delete("delete from student where id = #{id}")
	public void deleteById(int id);
	
	@DeleteProvider(type=Provider.class,method="deleteMore")
	public void deleteMore(@Param("ids") String ids);
	
	class Provider{
		public String deleteMore(String ids) {
			return "delete from student where id in ("+ids+")";
			
		}
		public String addMore(List<Student>list) {
			StringBuffer sb = new StringBuffer();
			sb.append("insert into student(name,username,password,sex,age,birthday,createTime) values");
			for(Student s:list) {
				sb.append("(#{name},#{username},#{passwpord},#{sex},#{age},#{brithday},now()),");
			}
			return sb.substring(0,sb.length()-1);
		}
	}
}
