<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List" %>
<%@page import="com.beans.Subject" %>
<!DOCTYPE html>
<html>

<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>FIRST PAGE</title>
<%String Msg=(String)request.getAttribute("msg");%>

<script type="text/javascript">
function deletePrompt(){
	return confirm("Are you sure you want to delete this subject?");
}
</script>

<style type="text/css">
   #subjects {
  font-family: helvetica;
  border-collapse: collapse;
  text-align: center;
}
h2{
color: yellow;
background-color: red;
padding:10px;
}

#subjects td, #subjects th {
  border: 1px solid black;
  padding: 8px;
  background-color:#f2f2f2;
  font-weight: bold;
}

#subjects tr:{background-color:#FFFFFF;}

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
#buttonlink:link, #buttonlink:visited {
  background-color: red;
  color: yellow;
  padding: 8px 10px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  border: 2px solid black;
}

#buttonlink:hover, #buttonlink:active {
  background-color:#4CAF50 ;
}
</style>
</head>

<body>
<p class="text-center">
<h2>WELCOME TO ARYAK'S ATTENDANCE MANAGER SYSTEM</h2>
<HR>
</p>

<div class="container">
<p class="text-center">
<h3 align="center"><b>YOUR SUBJECT LIST:</b></h3> 
</p>
<p class="text-center">
<font color="red"><% out.println(Msg);%></font>
</p>

<p class="text-center">


<div>     
  <table align="center" id="subjects">
    <thead>
      <tr>
        <th>NAME</th>
        <th>ATTENDED</th>
        <th>TOTAL</th>
        <th>OPTIONS</th>
      </tr>
    </thead>
    <tbody>
        
<% 
List <Subject> list = (List<Subject>)request.getAttribute("list");
for(Subject s:list){
%>

      <tr>
        <td><%out.println(s.getName());%></td>
        <td><%out.println(s.getAttended()); %></td>
        <td><%out.println(s.getTotal()); %></td>
        <td><a href="AppServlet?id=delete&sname=<%=s.getName() %>"><button class="btn btn-primary" onclick="return deletePrompt()">REMOVE</button></a>
        &nbsp;&nbsp;
        <a href="AppServlet?id=update&sname=<%=s.getName() %>"><button class="btn btn-primary">UPDATE</button></a></td>
      </tr>
    <% 
}
%>
</p>
    
    </tbody>
  </table>
</div>



<BR>
<br>
<p class="text-center">
<a href="AppServlet?id=add_subject" id="buttonlink">ADD A NEW SUBJECT</a>

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<a href="AppServlet?id=calculate" id="buttonlink">GENERATE REPORT CARD</a>
</p>
<br>

</div>

</body>
</html>