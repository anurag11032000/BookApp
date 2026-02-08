<%-- 

<%
String name = (String)session.getAttribute("name");
if(name == null) {
	response.sendRedirect("sessionError.html");
}else {
	
%>

<!DOCTYPE html>

<%@ page import="com.anurag.entity.Book" %>
<%@ page import="java.util.List" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1> Book App</h1>
	<hr>
	<p>
		<a href='UserHome.jsp'>Home</a> &nbsp;&nbsp;&nbsp;&nbsp
		<a href='Logout'>Logout</a> &nbsp;&nbsp;&nbsp;&nbsp
		Welcome :<b><%= name %></b>
	</p>
	<hr>
	<%
	String msg = (String)session.getAttribute("msg");
	if(msg!=null) {
	%>
		<p style='background-color:yellow;'><%= msg%></p>
	<% 
		session.setAttribute("msg", null);
	}
	%>
	<h2>Add New Book</h2>
	<form action="AddBook" method = "post" enctype="multipart/form-data">
		<label>Name:</label>
		<input type = "text" name = "name" required />
		<br><br>
		<label>Author Name</label>
		<input type = "text" name = "aname" required />
		<br><br>
		<label>Publisher Name:</label>
		<input type = "text" name = "pname" required />
		<br><br>
		<label>Price:</label>
		<input type = "number" name = "price" required>
		<br><br>
		<label>Content:</label>
		<input type = "file" accept = ".pdf" name = "content"  />
		<br><br>
		<label>Image:</label>
		<input type = "file" accept = ".jpg,.png,.jpeg" name = "image">
		<br><br>
		<button>Submit</button>
	</form>"
</body>
</html>
 <% 
 } 
 %>
 
 --%>
 
 
 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.anurag.entity.Book" %>
<%@ page import="java.util.List" %>

<%
String name = (String) session.getAttribute("name");
if (name == null) {
    response.sendRedirect("sessionError.html");
    return;
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Book | Book App</title>

<style>
    body {
        font-family: Arial, Helvetica, sans-serif;
        background: #f4f6f9;
        margin: 0;
        padding: 0;
    }

    header {
        background: #4a6cf7;
        color: white;
        padding: 15px;
        text-align: center;
    }

    nav {
        background: white;
        padding: 10px;
        text-align: center;
        box-shadow: 0 2px 5px rgba(0,0,0,0.1);
    }

    nav a {
        text-decoration: none;
        color: #4a6cf7;
        font-weight: bold;
        margin: 0 15px;
    }

    nav span {
        margin-left: 15px;
        font-weight: bold;
    }

    .container {
        max-width: 500px;
        background: white;
        margin: 30px auto;
        padding: 25px;
        border-radius: 10px;
        box-shadow: 0 6px 15px rgba(0,0,0,0.15);
    }

    h2 {
        text-align: center;
        margin-bottom: 20px;
    }

    label {
        font-weight: bold;
        display: block;
        margin-top: 10px;
    }

    input {
        width: 100%;
        padding: 8px;
        margin-top: 5px;
        border-radius: 5px;
        border: 1px solid #ccc;
    }

    button {
        width: 100%;
        margin-top: 20px;
        background: #4a6cf7;
        color: white;
        border: none;
        padding: 10px;
        font-size: 16px;
        border-radius: 5px;
        cursor: pointer;
    }

    button:hover {
        background: #3a56c5;
    }

    .msg {
        background: #fff3cd;
        padding: 10px;
        border-radius: 5px;
        margin-bottom: 15px;
        text-align: center;
        font-weight: bold;
    }
</style>
</head>

<body>

<header>
    <h1>Book App</h1>
</header>

<nav>
    <a href="UserHome.jsp">Home</a>
    <a href="Logout">Logout</a>
    <span>Welcome: <%= name %></span>
</nav>

<div class="container">

<%
String msg = (String) session.getAttribute("msg");
if (msg != null) {
%>
    <div class="msg"><%= msg %></div>
<%
    session.setAttribute("msg", null);
}
%>

<h2>Add New Book</h2>

<form action="AddBook" method="post" enctype="multipart/form-data">

    <label>Name:</label>
    <input type="text" name="name" required>

    <label>Author Name:</label>
    <input type="text" name="aname" required>

    <label>Publisher Name:</label>
    <input type="text" name="pname" required>

    <label>Price:</label>
    <input type="number" name="price" required>

    <label>Content (PDF):</label>
    <input type="file" name="content" accept=".pdf">

    <label>Image:</label>
    <input type="file" name="image" accept=".jpg,.jpeg,.png">

    <button type="submit">Add Book</button>
</form>

</div>

</body>
</html>
 
 
 
 
 