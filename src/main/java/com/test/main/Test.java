package com.test.main;


import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.test.dao.StudentDAO;
import com.test.models.Student;

public class Test {
	

	public static void main(String[] args) {

		 @SuppressWarnings("resource")
		ApplicationContext resource = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		 StudentDAO studentDAO = resource.getBean("studentDAO",StudentDAO.class);
		 
		 Student student = new Student();
		 student.setName("Faseeh");
		 student.setRollNum("16SW77");
		 student.setEmail("faseeh@gmail.com");
		 student.setSalary(3000);
		 student.setDeptId(3);
		 
		 studentDAO.addStudent(student);
		
		 //System.out.println(studentDAO.getStudentById(42).getName());
		 
		 List<Student> students = studentDAO.getAllStudents();
		 
		 students.stream().forEach(s->{
			 System.out.println(s.getName());
		 });
		
		/*
		 * JdbcTemplate jdbcTemplate =
		 * resource.getBean("jdbcTemplate",JdbcTemplate.class);
		 * 
		 * String query="insert into student(name,roll_num) values('Turab','18CS45')";
		 * 
		 * //jdbcTemplate.update(query);
		 * 
		 * System.out.println("Saved!!!");
		 * 
		 * DataSource dataSource = resource.getBean("ds",DataSource.class);
		 * 
		 * Connection connection = dataSource.getConnection();
		 * 
		 * Statement statement = connection.createStatement();
		 * 
		 * ResultSet resultSet = statement.executeQuery("select * from student");
		 * 
		 * while(resultSet.next()) { System.out.println(resultSet.getString("name")); }
		 * connection.close();
		 */
		
	//	ResultSet resultSet = jdbcTemplate.query("select * from student");
		
		
		
		
		/*
		 * List<String> list = new ArrayList<>();
		 * 
		 * list.add("A"); list.add("B"); list.add("Abdul"); list.add("C");
		 * list.add("D");
		 * 
		 * 
		 * 
		 * List<String> a=
		 * list.stream().filter(s->s.startsWith("A")).collect(Collectors.toList());
		 * 
		 * a.stream().forEach(l->System.out.println(l));
		 */
		/*
		 * Student student=(Student)resource.getBean("studentbean");
		 * student.setName("Fasih Tahir Lead Developer"); student.displayInfo();
		 */

		/*
		 * AnnotationConfigApplicationContext context = new
		 * AnnotationConfigApplicationContext(AppConfig.class);
		 * 
		 * Student s = context.getBean(Student.class); Student s1 =
		 * context.getBean(Student.class); System.out.println(s);
		 * System.out.println(s1);
		 */

	}

}
