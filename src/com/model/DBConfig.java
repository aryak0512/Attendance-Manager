package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.beans.Subject;

public class DBConfig {
	//Step 1 : declare all variables 
		String url="jdbc:mysql://localhost:3306/subject";
		String username="root";
		String password="";
		String driver="com.mysql.jdbc.Driver";
		Connection conn;
		
		
		//Step 2
		private void dbConnect() throws ClassNotFoundException, SQLException{
			//Load the driver
			Class.forName(driver);
			//establish the connection
			conn = DriverManager.getConnection(url, username, password);
		}

		public List<Subject> fetchSubjects() throws SQLException, ClassNotFoundException {
			// TODO Auto-generated method stub
			 dbConnect();
			 String sql="select * from subjects";
			 //Step 3: creating the statement
			 PreparedStatement pstmt = conn.prepareStatement(sql);
			 //step 4: executing the statement
			 ResultSet rst = pstmt.executeQuery();
			 List<Subject> list = new ArrayList<>();
			 while(rst.next()){
				 int id = rst.getInt("id");
				 String name = rst.getString("name");
				 String attended = rst.getString("attended");
				 String total = rst.getString("total");
				 Subject s = new Subject();
				 s.setId(id);
				 s.setName(name);
				 s.setTotal(total);
				 s.setAttended(attended);
				 list.add(s); 
			 }
			 rst.close();
			 pstmt.close();
			return list;
		}

		public void addSubjects(Subject s) throws SQLException, ClassNotFoundException {
			// TODO Auto-generated method stub
			 dbConnect();
			 String sql="insert into subjects(name,attended,total)values(?,?,?)";
			 //Step 3: creating the statement
			 PreparedStatement pstmt = conn.prepareStatement(sql);
			 pstmt.setString(1, s.getName());
			 pstmt.setString(2, s.getAttended());
			 pstmt.setString(3, s.getTotal());
			 pstmt.executeUpdate();	
		}

		public double calculatePercentage() throws SQLException, ClassNotFoundException {
			double percent=0.0;
			double percentRoundOff=0.0;
			int attended=0;
			int total=0;
			dbConnect();
			String sql="select SUM(attended),SUM(total) from subjects;";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rst=pstmt.executeQuery();
			while(rst.next()) {
				attended=Integer.parseInt(rst.getString("SUM(attended)"));
				System.out.println("attended:"+attended);//12
				total=Integer.parseInt(rst.getString("SUM(total)"));
				System.out.println("total:"+total);
				
				
				float value=(float)attended/total; //value will be 0.(something)....
				System.out.println("Value:"+value*100);//this will give a lengthy decimal value
				percent = value*100;	
			    percentRoundOff = Math.round(percent * 100.0) / 100.0;//upto 2 decimal places
				System.out.println("Rounded off:"+percentRoundOff);
			}
			return percentRoundOff;
		}

		public void deleteSubject(String sname) throws ClassNotFoundException, SQLException {
			// TODO Auto-generated method stub
			 dbConnect();
			 String sql="delete from subjects where name=?";
			 //Step 3: creating the statement
			 PreparedStatement pstmt = conn.prepareStatement(sql);
			 pstmt.setString(1, sname);
			 pstmt.executeUpdate();
			
		}

		public int[] getSubjectData(String name) throws SQLException, ClassNotFoundException {
			// TODO Auto-generated method stub
			 dbConnect();
			 int attended;
			 int total;
			 int a[]=new int[2];
			 String sql="select attended,total from subjects where name=?";
			 //Step 3: creating the statement
			 PreparedStatement pstmt = conn.prepareStatement(sql);
			 //step 4: executing the statement
			 pstmt.setString(1, name);
			 ResultSet rst = pstmt.executeQuery();
			 while(rst.next()) {
					attended=Integer.parseInt(rst.getString("attended"));
					System.out.println("attended:"+attended);
					total=Integer.parseInt(rst.getString("total"));
					System.out.println("total:"+total);
					a[0]=attended;
					a[1]=total;
				}
			 return a;
			
		}

		public void updateSubject(String subject_name, String attended, String total) throws ClassNotFoundException, SQLException {
			// TODO Auto-generated method stub
			dbConnect();
			String sql="update subjects SET attended=?,total=? where name=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, attended);
			pstmt.setString(2, total);
			pstmt.setString(3, subject_name);
			pstmt.executeUpdate();	
			
		}
		

}
