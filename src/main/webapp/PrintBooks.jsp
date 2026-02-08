<%-- 
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
	<a href="index.html">Home</a> &nbsp;&nbsp;&nbsp;&nbsp;
	<a href="login.html">Login</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<hr>
	<section style='display:flex; flex-wrap:wrap;'>
	<%
	List<Book> books = (List)request.getAttribute("books");
	for(Book b : books) {
	%>
			<div style="
				    border:1px solid #333;
				    padding:15px;
				    width:300px;
				    margin:20px auto;
				    background: linear-gradient(135deg, #fdfbfb, #ebedee);
				    box-shadow: 0 4px 8px rgba(0,0,0,0.2);
				    border-radius:10px;
				    font-family:Arial;
				">
				<img height ='100px' src ='GetImage?name=<%= b.getName()%>'/>
				<p>Name: <%= b.getName()%></p>
				<p>Price: <%= b.getPrice()%></p>
				<a href = 'BookDetails.jsp?name=<%= b.getName()%>'> More Details</a>
				<br><br>
				<form action='BookDetails.jsp' method='post'>
				<input type='hidden' name='name' value='<%= b.getName()%>'>
				<button>More Details</button>
				</form>
				</div>
	  <% } %>
	  </section>
</body>
</html>

--%>

<%@ page import="com.anurag.entity.Book" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book List</title>

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
        padding: 20px;
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

    nav a:hover {
        text-decoration: underline;
    }

    .book-container {
        display: flex;
        flex-wrap: wrap;
        justify-content: center;
        padding: 30px;
    }

    .book-card {
        width: 280px;
        background: white;
        margin: 15px;
        border-radius: 10px;
        box-shadow: 0 6px 15px rgba(0,0,0,0.15);
        padding: 15px;
        text-align: center;
        transition: transform 0.2s ease;
    }

    .book-card:hover {
        transform: translateY(-5px);
    }

    .book-card img {
        height: 120px;
        margin-bottom: 10px;
        border-radius: 5px;
    }

    .book-card p {
        margin: 8px 0;
        color: #333;
        font-size: 15px;
    }

    .price {
        font-weight: bold;
        color: #2c7be5;
    }

    .book-card a {
        display: inline-block;
        margin-top: 10px;
        text-decoration: none;
        color: #4a6cf7;
        font-weight: bold;
    }

    .book-card a:hover {
        text-decoration: underline;
    }

    .book-card button {
        margin-top: 10px;
        background: #4a6cf7;
        color: white;
        border: none;
        padding: 8px 15px;
        border-radius: 5px;
        cursor: pointer;
        font-size: 14px;
    }

    .book-card button:hover {
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

<section class="book-container">
<%
    List<Book> books = (List<Book>) request.getAttribute("books");
    if (books != null) {
        for (Book b : books) {
%>
    <div class="book-card">
        <img src="GetImage?name=<%= b.getName() %>" alt="Book Image">

        <p><strong>Name:</strong> <%= b.getName() %></p>
        <p class="price">Price: <%= b.getPrice() %></p>

        <a href="BookDetails.jsp?name=<%= b.getName() %>">More Details</a>

        <form action="BookDetails.jsp" method="post">
            <input type="hidden" name="name" value="<%= b.getName() %>">
            <button type="submit">More Details</button>
        </form>
    </div>
<%
        }
    }
%>
</section>

</body>
</html>
