<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<meta charset="ISO-8859-1">
<title>UPDATE ATTENDANCE</title>
<%
String name=(String)request.getAttribute("subjectname");
int old_attended= (Integer)request.getAttribute("attended");
int old_total= (Integer)request.getAttribute("total");
String Msg=(String)request.getAttribute("msg");
%>
<style>
h2{
color: yellow;
background-color: red;
padding:10px;
}
</style>
</head>
<body background="C:\xampp\htdocs\formbg1.jpg">
<h2>WELCOME TO ARYAK'S ATTENDANCE MANAGER SYSTEM</h2>
<HR>
<div class="container">

<form action="AppServlet?id=update_subject" method="post">
<fieldset>
<legend>Enter subject details:</legend>
<br>
<p class="text-center">
<b>ENTER SUBJECT NAME:</b>
</p>
<p class="text-center">
<input type="text" name="subject_name" value="<% out.println(name);%>"required></input>
</p>

<p class="text-center">
-------------------------------------------------
</p>

<p class="text-center">
<b>Total no. of lectures:</b>
</p>

<p class="text-center">
<select name="total_lectures" required>
    <option selected="selected"><% out.print(old_total);%></option>
    <option value="0">00</option>
    <option value="1">01</option>
    <option value="2">02</option>
    <option value="3">03</option>
    <option value="4">04</option>
    <option value="5">05</option>
    <option value="6">06</option>
    <option value="7">07</option>
    <option value="8">08</option>
    <option value="9">09</option>
    <option value="10">10</option>
    <option value="11">11</option>
    <option value="12">12</option>
    <option value="13">13</option>
    <option value="14">14</option>
    <option value="15">15</option>
    <option value="16">16</option>
    <option value="17">17</option>
    <option value="18">18</option>
    <option value="19">19</option>
    <option value="20">20</option>
    
  </select>
</p>
<br>
<p class="text-center">
<b>No. of lectures attended:</b>
</p>

<p class="text-center">
<select name="attended_lectures" value="<% out.println(old_attended);%>" required>
    <option selected="selected"><% out.print(old_attended);%></option>
    <option value="0">00</option>
    <option value="1">01</option>
    <option value="2">02</option>
    <option value="3">03</option>
    <option value="4">04</option>
    <option value="5">05</option>
    <option value="6">06</option>
    <option value="7">07</option>
    <option value="8">08</option>
    <option value="9">09</option>
    <option value="10">10</option>
    <option value="11">11</option>
    <option value="12">12</option>
    <option value="13">13</option>
    <option value="14">14</option>
    <option value="15">15</option>
    <option value="16">16</option>
    <option value="17">17</option>
    <option value="18">18</option>
    <option value="19">19</option>
    <option value="20">20</option>
  </select>
</p>

<p class="text-center">
<font color="red"><% out.println(Msg);%></font>
</p>

<p class="text-center">
-------------------------------------------------
</p>

<p class="text-center">
<input type="submit" class="btn btn-primary" value="UPDATE SUBJECT">
</p>
<br>
<p class="text-center">
<a href="AppServlet?id=back">BACK TO HOME PAGE</a>
</p>
</fieldset>
</form>
</div>





</body>
</html>