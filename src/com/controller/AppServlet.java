package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.Subject;
import com.service.UserService;

public class AppServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Subject> list = new ArrayList();
		String id = request.getParameter("id");
		UserService userservice = new UserService();
		if(id==null ||id.equals("back")) {
			
			try {
				list=userservice.fetchSubjects();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            System.out.println(list);
			request.setAttribute("list", list);
			request.setAttribute("msg", "");
			request.setAttribute("msg1", "");
			request.setAttribute("msg2", "");
			request.getRequestDispatcher("firstpage.jsp").forward(request, response);
		}
		else {
			doPost(request,response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if(id.equals("add_subject")) {
			request.setAttribute("subj","");
			request.setAttribute("msg", "");
			request.getRequestDispatcher("addsubject.jsp").forward(request, response);
		}
		
		if(id.equals("delete")) {
			String sname = request.getParameter("sname");
			System.out.println(sname);
			UserService userservice = new UserService();
			try {
				userservice.deleteProduct(sname);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List <Subject >list =new ArrayList();
			try {
				list = userservice.fetchSubjects();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("list", list);
			request.setAttribute("msg", "The Subject:" + sname + " is deleted. ");
			request.getRequestDispatcher("firstpage.jsp").forward(request, response);
		}
		
		if(id.equals("create_subject")) {
			String subject_name= request.getParameter("subject_name");
			//System.out.println(subject_name);
			
			String total=request.getParameter("total_lectures");
			int total_lectures= Integer.parseInt(request.getParameter("total_lectures"));
			//System.out.println(total);
			
			String attended=request.getParameter("attended_lectures");
			int attended_lectures= Integer.parseInt(request.getParameter("attended_lectures"));
			//System.out.println(attended);
			if(attended_lectures>total_lectures) {
				request.setAttribute("subj",subject_name);
				request.setAttribute("msg", "Enter valid number of lectures.");
				request.getRequestDispatcher("addsubject.jsp").forward(request, response);
			}
			else {
			    List <Subject>list=new ArrayList();
				UserService userservice = new UserService();
				Subject s = new Subject();
				s.setName(subject_name);
				s.setAttended(attended);
				s.setTotal(total);
				try {
					userservice.addSubject(s);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					list =userservice.fetchSubjects();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("list", list);
				request.setAttribute("msg", "New subjects are added in list.");
				request.getRequestDispatcher("firstpage.jsp").forward(request, response);
				
			}
		}
			if(id.equals("calculate")) {
				double percent=0.0;
				UserService userservice = new UserService();
				try {
					percent=userservice.calculatePercentage();
					System.out.println("servlet:"+percent);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				List<Subject> records = new ArrayList();
				
					try {
						records=userservice.fetchSubjects();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				if(percent>=75) {
					String Percent=Double.toString(percent);
					request.setAttribute("percent", Percent);
					request.setAttribute("records", records);
					request.setAttribute("msg2", "YOU ARE A NOT DEFAULTER.");
					request.getRequestDispatcher("resultpage.jsp").forward(request, response);		
				}
				else {
					String Percent=Double.toString(percent);
					request.setAttribute("percent", Percent);
					request.setAttribute("records1", records);
					request.setAttribute("msg1", "YOU ARE A DEFAULTER!!!");
					request.getRequestDispatcher("resultpage1.jsp").forward(request, response);

				}
			
			}
			
			if(id.equals("update")) {
				String name = request.getParameter("sname");
				//System.out.println(name);
				int a[]=new int[2];
				UserService userservice = new UserService();
				try {
					a=userservice.getSubjectData(name);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//System.out.println("In servlet:"+a[0]);
				//System.out.println("In servlet:"+a[1]);
				request.setAttribute("subjectname", name);
				request.setAttribute("attended", a[0]);
				request.setAttribute("total", a[1]);
				request.setAttribute("msg", "");
				request.getRequestDispatcher("updatepage.jsp").forward(request, response);

			}
			if(id.equals("update_subject")) {
				List<Subject> list=new ArrayList();
				String subject_name=request.getParameter("subject_name");
				String attended = request.getParameter("attended_lectures");
				String total = request.getParameter("total_lectures");
				//System.out.println("New a:"+attended);
				//System.out.println("New t:"+total);
				int At =Integer.parseInt(attended);
				int To =Integer.parseInt(total);
				System.out.println(At);//9
				System.out.println(To);//6
				if(At>To) {
					System.out.println("I canme inside if statement");
					request.setAttribute("subjectname",subject_name);
					request.setAttribute("attended",At);
					request.setAttribute("total",To);
					request.setAttribute("msg", "Enter valid number of lectures.");
					request.getRequestDispatcher("updatepage.jsp").forward(request, response);
				}
				else {
					UserService userservice = new UserService();
					try {
						userservice.updateSubject(subject_name,attended,total);
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                try {
						list=userservice.fetchSubjects();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                request.setAttribute("list", list);
	                request.setAttribute("msg", "Attendance has been updated.");
	    			request.getRequestDispatcher("firstpage.jsp").forward(request, response);
				}
				
			}
		
		}
		
	}


