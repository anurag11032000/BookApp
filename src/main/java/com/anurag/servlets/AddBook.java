package com.anurag.servlets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import org.hibernate.Session;

import com.anurag.HbUtility;
import com.anurag.entity.Book;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import jakarta.transaction.Transaction;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;

/**
 * Servlet implementation class AddBook
 */
@WebServlet("/AddBook")
@MultipartConfig
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AddBook() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//    private byte[] readBytes(InputStream is) throws IOException {
//        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//        byte[] buffer = new byte[4096];
//        int bytesRead;
//        while ((bytesRead = is.read(buffer)) != -1) {
//            bos.write(buffer, 0, bytesRead);
//        }
//        return bos.toByteArray();
//    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session == null) {
			response.sendRedirect("sessionError.html");
		}else {
			String name = request.getParameter("name");
			String aname = request.getParameter("aname");
			String pname = request.getParameter("pname");
			int price = Integer.parseInt(request.getParameter("price"));
			Part p1 = request.getPart("content");
			Part p2 = request.getPart("image");
			
//			if (p1.getSize() > 10 * 1024 * 1024) {
//			    session.setAttribute("msg", "PDF size exceeds 10MB!");
//			    response.sendRedirect("UserHome.jsp");
//			    return;
//			}
//
//			if (p2.getSize() > 2 * 1024 * 1024) {
//			    session.setAttribute("msg", "Image size exceeds 2MB!");
//			    response.sendRedirect("UserHome.jsp");
//			    return;
//			}

			InputStream i1 = p1.getInputStream();
			InputStream i2 = p2.getInputStream();
//			byte[] content = readBytes(i1);
//			byte[] image = readBytes(i2);
			byte[] content = i1.readAllBytes();
			byte[] image = i2.readAllBytes();
			if(content.length > 10*1000*1000) {
				session.setAttribute("msg", "Pdf size Exceeds!!");
			}
			else if(image.length > 2*1000*1000) {
				session.setAttribute("msg", "Image size Exceeds!!");
			}else {
				Session ses = HbUtility.getSessionFactory().openSession();
				org.hibernate.Transaction transaction = ses.beginTransaction();
				Book book = ses.get(Book.class, name);
				if(book == null) {
					Book b = new Book();
					b.setName(name);
					b.setAname(aname);
					b.setPname(pname);
					b.setPrice(price);
					if(content.length>0) {
						b.setContent(content);
					}
					if(image.length > 0 ) {
						b.setImage(image);
					}
					ses.persist(b);
					transaction.commit();
					ses.close();
					session.setAttribute("msg", "Book Added Successfully!");
					
					
				}else {
					session.setAttribute("msg", "Book Already Exist!");
				}
			}
			response.sendRedirect("UserHome.jsp");
			
		}
		
		
	}

}
