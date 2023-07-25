package com.kh.jdbc.day04.student.model;

import java.sql.Connection;
import java.util.List;

import com.kh.jdbc.day04.student.common.JDBCTemplate;
import com.kh.jdbc.day04.student.model.dao.StudentDAO;
import com.kh.jdbc.day04.student.model.vo.Student;

public class StudentService {
	private StudentDAO sDao;
	private JDBCTemplate jdbcTemplate;
	
	public StudentService() {
		sDao = new StudentDAO();
//		jdbcTemplate = new JDBCTemplate();
		jdbcTemplate = JDBCTemplate.getInstance();
	}

	public List<Student> selectAll() {
		Connection conn
			= jdbcTemplate.createConnection();
		List<Student> sList
			= sDao.selectAll(conn);
		return sList;
	}

	public Student selectOneById(String studentId) {
		Connection conn
			= jdbcTemplate.createConnection();
		Student student = sDao.selectOneById(conn, studentId);
		return student;
	}

	public List<Student> selectAllByName(String studentName) {
		Connection conn
			= jdbcTemplate.createConnection();
		List<Student> sList
			= sDao.selectAllByName(conn, studentName);
		return sList;
	}

	public int insertStudent(Student student) {
		Connection conn
			= jdbcTemplate.createConnection();
		int result = sDao.insertStudent(conn, student);
		return result;
	}

	public int updateStudent(Student student) {
		Connection conn
		= jdbcTemplate.createConnection();
		int result = sDao.updateStudent(conn, student);
		return result;
	}

	public int deleteStudent(String studentId) {
		Connection conn
		= jdbcTemplate.createConnection();
		int result = sDao.deleteStudent(conn, studentId);
		return result;
	}
}
