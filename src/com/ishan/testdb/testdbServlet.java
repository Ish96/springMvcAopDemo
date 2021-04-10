package com.ishan.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class testdbServlet
 */
@WebServlet("/testdbServlet")
public class testdbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		String jdbcUrl = "jdbc:postgresql://localhost:5432/Customer_tracker?userSSL=false";
		String user = "springstudent@localhost";
		String pass = "springstudent";
		String driver = "org.postgresql.Driver";
		
		try {
			PrintWriter pw = response.getWriter();
			
			pw.print("connection url" + jdbcUrl);
			
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(jdbcUrl,user,pass);
			pw.print("Success");
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
