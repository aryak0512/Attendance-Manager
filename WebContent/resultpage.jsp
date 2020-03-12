<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List" %>
    <%@page import="com.beans.Subject" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<meta charset="ISO-8859-1">
<title>REPORT CARD</title>
<style type="text/css">
   #subjects {
  font-family: helvetica;
  border-collapse: collapse;
  text-align: center;
}

#subjects td, #subjects th {
  border: 1px solid black;
  padding: 8px;
}
h2{
color: yellow;
background-color: red;
padding:10px;
}
#subjects tr:nth-child(even){background-color: #f2f2f2;}

#subjects tr:hover {background-color: #ddd;}

#subjects th {
  padding-top: 8px;
  padding-bottom: 5px;
  text-align: center;
  background-color: #4CAF50;
  color: white;
}
h3{
  color: black;
  font-family: arial;
  font-size: 20px;
  font-weight: normal;
  margin: 5px;
  margin-top: 5px;
}

</style>
</head>
<body>
<p class="text-center">
<h2>WELCOME TO ARYAK'S ATTENDANCE MANAGER SYSTEM</h2>
</p>
<br>
<div class="container">
<br>
<p class="text-center"><font color="red"><b><u>YOUR REPORT CARD:</u></b></font></p>
<br>

<%
String msg2= (String)request.getAttribute("msg2");
String Percent=(String)request.getAttribute("percent");
double percent = Double.parseDouble(Percent);
System.out.println(percent);
%>
<p class="text-center">
<h3>
<p class="text-center">
<font color="green"><% out.println(msg2);%></font>
</h3>

<br>
<div>     
  <table align="center" id="subjects">
    <thead>
      <tr>
        <th>NAME</th>
        <th>ATTENDED</th>
        <th>TOTAL</th>
      </tr>
    </thead>
    <tbody>
        
<% 
List <Subject> list = (List<Subject>)request.getAttribute("records");
for(Subject s:list){
%>

      <tr>
        <td><%out.println(s.getName());%></td>
        <td><%out.println(s.getAttended()); %></td>
        <td><%out.println(s.getTotal()); %></td>
      </tr>
    <% 
}
%>
</p>
    
    </tbody>
  </table>
</div>



<BR>


<h3 class="text-center">
Your attendance is:
</h3>

<h1>
<p class="text-center">
<font color="blue"><% out.println(percent+"%");%></font>
</p>
</h1>



<p class="text-center">
<font color="red">(*Minimum attendance criteria=75%)</font>
</p>

<p class="text-center">
<a href="AppServlet?id=back">BACK TO HOME PAGE</a>
</p>
</div>

</body>
</html>