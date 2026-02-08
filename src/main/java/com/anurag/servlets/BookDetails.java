                                                                                                                               package com.anurag.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.anurag.HbUtility;
import com.anurag.entity.Book;

/**
 * Servlet implementation class SearchBook
 */
@WebServlet("/BookDetails")
public class BookDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public BookDetails() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(jakarta.servlet.http.HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		Session ses = HbUtility.getSessionFactory().openSession();
		Book b = ses.get(Book.class, name);
		ses.close();
		if(b == null) {
			response.sendRedirect("notFound.html");
		}else {
			PrintWriter out = response.getWriter();
			out.print("<html>");
			out.print("<body>");
			out.print("<h1> Book App </h1>");
			out.print("<hr>");
			out.print("<a href = 'index.html'>Home</a>");
			out.print("<hr>");
			out.print("<div style='"
			        + "border:1px solid #333;"
			        + "padding:15px;"
			        + "width:300px;"
			        + "margin:20px auto;"
			        + "background: linear-gradient(135deg, #fdfbfb, #ebedee);"
			        + "box-shadow: 0 4px 8px rgba(0,0,0,0.2);"
			        + "border-radius:10px;"
			        + "font-family:Arial;'>");
			out.print("<img height ='100px' src ='GetImage?name="+b.getName()+"'/>");
			out.print("<p>Name: "+b.getName()+"</p>");
			out.print("<p>Author Name: "+b.getAname()+"</p>");
			out.print("<p>Publisher Name: "+b.getPname()+"</p>");
			out.print("<p>Price: "+b.getPrice()+"</p>");
			out.print("<hr/>");
			out.print("<a target='_blank' href ='GetPdf?name="+b.getName()+"'>View Pdf</a>");
			out.print("<form action='DownloadPdf' method='post'>");
			out.print("<input type='hidden' name='name' value='"+b.getName()+"'>");
			out.print("<br>");
			out.print("<button>Download Pdf</button>");
			out.print("</form>");
			out.print("</div>"); 
			out.print("</body>");
			out.print("</html>");
			out.close();
		}
		
		
		
		
		
		
		
	}

}
