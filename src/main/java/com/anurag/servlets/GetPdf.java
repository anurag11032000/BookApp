package com.anurag.servlets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
@WebServlet("/GetPdf")
public class GetPdf extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public GetPdf() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
	protected void service(jakarta.servlet.http.HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		
		
		Session ses = HbUtility.getSessionFactory().openSession();
		Book book = ses.get(Book.class, name);
		ses.close();
		
		if(book == null ) {
			response.sendRedirect("notFound.html");
		}else if(book.getContent()!=null) {
			response.getOutputStream().write(book.getContent());
		}
		
		
	}

}
