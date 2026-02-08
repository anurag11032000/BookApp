package com.anurag.servlets;

import java.io.IOException;

import org.hibernate.Session;

import com.anurag.HbUtility;
import com.anurag.entity.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Login() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		Session ses = HbUtility.getSessionFactory().openSession();
		User user = ses.get(User.class, id);
		if(user != null) {
			if(user.getPassword().equals(password)) {
				HttpSession session = request.getSession();
				session.setAttribute("name", user.getName());
				response.sendRedirect("UserHome.jsp");
			}else {
				response.sendRedirect("loginError.html");
			}
		}else {
			response.sendRedirect("loginError.html");
		}
		
	}

}
