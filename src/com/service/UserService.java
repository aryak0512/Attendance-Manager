package com.service;

import java.sql.SQLException;
import java.util.List;

import com.beans.Subject;
import com.model.DBConfig;

public class UserService {

	public List<Subject> fetchSubjects() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		DBConfig dbconfig = new DBConfig();
		return dbconfig.fetchSubjects();
		
	}

	public void addSubject(Subject s) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		DBConfig dbconfig = new DBConfig();
		dbconfig.addSubjects(s);
		
	}

	public double calculatePercentage() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		DBConfig dbconfig = new DBConfig();
		return dbconfig.calculatePercentage();
		
	}

	public void deleteProduct(String sname) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		DBConfig dbconfig = new DBConfig();
		dbconfig.deleteSubject(sname);
		
	}

	public int[] getSubjectData(String name) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		DBConfig dbconfig = new DBConfig();
		return dbconfig.getSubjectData(name);
		
	}

	public void updateSubject(String subject_name, String attended, String total) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		DBConfig dbconfig = new DBConfig();
		dbconfig.updateSubject(subject_name,attended,total);
	}

}
