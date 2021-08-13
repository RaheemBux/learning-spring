package com.test.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.test.dao.StudentDAO;
import com.test.models.Student;

public class StudentDAOImpl implements StudentDAO{
	
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Student> getAllStudents() {
		String sql = "select * from student";
		return jdbcTemplate.query(sql, new StudentMapper());
	}

	@SuppressWarnings("deprecation")
	@Override
	public Student getStudentById(Integer studentId) {
		String sql = "select * from student where id =? ";
		return jdbcTemplate.queryForObject(sql, new Object [] {studentId}, new StudentMapper());
	}

	@Override
	public Integer addStudent(Student student) {
		String sql = "insert into student(name,roll_num,email,salary,dept_id) values(?,?,?,?,?)";
		return jdbcTemplate.update(sql, new Object [] {student.getName(),student.getRollNum(),student.getEmail(),student.getSalary(),student.getDeptId()});
	}
	
	private static final class StudentMapper implements RowMapper<Student>{

		@Override
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			Student student = new Student();
			student.setId(rs.getInt("id"));
			student.setName(rs.getString("name"));
			student.setEmail(rs.getString("email"));
			student.setRollNum(rs.getString("roll_num"));
			student.setSalary(rs.getInt("salary"));
			student.setDeptId(rs.getInt("dept_id"));
			return student;
		}
		
	}

}
