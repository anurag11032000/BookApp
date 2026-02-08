
<%-- 
<%@ page import="com.anurag.HbUtility" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="com.anurag.entity.Book" %>
<%@ page import="java.util.List" %>
<%
	String name = request.getParameter("name");
		Session ses = HbUtility.getSessionFactory().openSession();
		Book b = ses.get(Book.class, name);
		ses.close();
		if(b == null) {
			response.sendRedirect("notFound.html");
		}else {

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1> Book App</h1>
	<hr>
	<a href="index.html">Home</a> &nbsp;&nbsp;&nbsp;&nbsp;
	<a href="login.html">Login</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<hr>
	
	<div style='"
			        + "border:1px solid #333;"
			        + "padding:15px;"
			        + "width:300px;"
			        + "margin:20px auto;"
			        + "background: linear-gradient(135deg, #fdfbfb, #ebedee);"
			        + "box-shadow: 0 4px 8px rgba(0,0,0,0.2);"
			        + "border-radius:10px;"
			        + "font-family:Arial;'>
		<img height ='100px' src ='GetImage?name=<%=b.getName()%>'/>
		<p>Name: <%=b.getName()%></p>
		<p>Author Name: <%=b.getAname()%></p>
		<p>Publisher Name: <%=b.getPname()%></p>
		<p>Price: <%=b.getPrice()%></p>
		<hr/>
		<a target='_blank' href ='GetPdf?name=<%=b.getName()%>'>View Pdf</a>
		<form action='DownloadPdf' method='post'>
		<input type='hidden' name='name' value='<%=b.getName()%>'>
		<br>
		<button>Download Pdf</button>
		</form>
	</div>
	<%
		}
	
	%>
</body>
</html>

--%>


<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.anurag.HbUtility" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="com.anurag.entity.Book" %>

<%
String bookName = request.getParameter("name");

Session ses = HbUtility.getSessionFactory().openSession();
Book b = ses.get(Book.class, bookName);
ses.close();

if (b == null) {
    response.sendRedirect("notFound.html");
    return;
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Details | Book App</title>

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

    .container {
        max-width: 350px;
        background: white;
        margin: 30px auto;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 6px 15px rgba(0,0,0,0.15);
        text-align: center;
    }

    .container img {
        height: 130px;
        margin-bottom: 10px;
        border-radius: 5px;
    }

    .container p {
        margin: 8px 0;
        color: #333;
    }

    .price {
        font-weight: bold;
        color: #2c7be5;
    }

    hr {
        border: none;
        height: 1px;
        background: #ddd;
        margin: 15px 0;
    }

    a.pdf-link {
        display: inline-block;
        margin-bottom: 10px;
        text-decoration: none;
        color: #4a6cf7;
        font-weight: bold;
    }

    button {
        background: #4a6cf7;
        color: white;
        border: none;
        padding: 8px 15px;
        border-radius: 5px;
        cursor: pointer;
        font-size: 14px;
    }

    button:hover {
        background: #3a56c5;
    }
</style>
</head>

<body>

<header>
    <h1>Book App</h1>
</header>

<nav>
    <a href="index.html">Home</a>
    <a href="login.html">Login</a>
</nav>

<div class="container">

    <img src="GetImage?name=<%= b.getName() %>" alt="Book Image">

    <p><strong>Name:</strong> <%= b.getName() %></p>
    <p><strong>Author:</strong> <%= b.getAname() %></p>
    <p><strong>Publisher:</strong> <%= b.getPname() %></p>
    <p class="price">Price: ₹ <%= b.getPrice() %></p>

    <hr>

    <a class="pdf-link" target="_blank" href="GetPdf?name=<%= b.getName() %>">
        View PDF
    </a>

    <form action="DownloadPdf" method="post">
        <input type="hidden" name="name" value="<%= b.getName() %>">
        <button type="submit">Download PDF</button>
    </form>

</div>

</body>
</html>



