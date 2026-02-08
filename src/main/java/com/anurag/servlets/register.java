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

//@WebServlet("/register")
//public class register extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//    /**
//     * Default constructor. 
//     */
//    public register() {
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String id = request.getParameter("id");
//		String password = request.getParameter("password");
//		String name = request.getParameter("name");
//		
//		Session ses = HbUtility.getSessionFactory().openSession();
//		User user = ses.get(User.class, id);
//		if(user != null) {
//			if(user.getPassword().equals(password)) {
//				HttpSession session = request.getSession();
//				session.setAttribute("name", user.getName());
//				response.sendRedirect("UserHome.jsp");
//			}else {
//				response.sendRedirect("loginError.html");
//			}
//		}else {
//			response.sendRedirect("loginError.html");
//		}
//		
//	}
//
//}


@WebServlet("/register")
public class register extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        

        Session ses = HbUtility.getSessionFactory().openSession();
        ses.beginTransaction();

        User existingUser = ses.get(User.class, id);

        if (existingUser != null) {
            // user already exists
            ses.getTransaction().rollback();
            ses.close();
            response.sendRedirect("registerError.html");
            return;
        }

        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPassword(password);

        ses.save(user);   // ✅ INSERT INTO USER TABLE
        ses.getTransaction().commit();
        ses.close();

        response.sendRedirect("login.html");
    }
}
