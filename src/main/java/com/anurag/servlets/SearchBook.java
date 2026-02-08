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
@WebServlet("/SearchBook")
public class SearchBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SearchBook() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(jakarta.servlet.http.HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		
		
		Session ses = HbUtility.getSessionFactory().openSession();
		List<Book> books = ses.createQuery("select b from Book b where b.name like :name", Book.class).setParameter("name", "%"+name+"%").list();
		ses.close();
		if(books.isEmpty()) {
			response.sendRedirect("notFound.html");
		}else {
			request.setAttribute("books", books);
			RequestDispatcher rd = request.getRequestDispatcher("PrintBooks.jsp");
			rd.forward(request, response);
		}
		
	}

}
