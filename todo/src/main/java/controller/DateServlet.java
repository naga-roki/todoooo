package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/date")
public class DateServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getAttribute("message") == null) {
			request.setAttribute("message", "todoを管理しましょ");
		}
		
		String sduedate = request.getParameter("sduedate");
	
		
		
		String url = "jdbc:mysql://localhost/todo";
		String user = "root";
		String password = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String sql = "SELECT * FROM posts ORDER BY duedate"+" "+ sduedate;
		try (Connection connection = DriverManager.getConnection(url,user,password);
		PreparedStatement statement =connection.prepareStatement(sql);
		){
		
			
			ResultSet results = statement.executeQuery();
ArrayList<HashMap<String, String>> rows = new ArrayList<HashMap<String, String>>();
			
			while(results.next()) {
				HashMap<String, String> columns = new HashMap<String, String>();
				
				String id = results.getString("id");
				columns.put("id", id);
				String title = results.getString("title");
				columns.put("title", title);
				String content = results.getString("content");
				columns.put("content", content);
				String priority = results.getString("priority");
				columns.put("priority", priority);
				String duedate = results.getString("duedate");
				columns.put("duedate", duedate);
				
				rows.add(columns);
			}
			request.setAttribute("rows", rows);
		} catch (Exception e) {
			request.setAttribute("message", "Exception:" + e.getMessage());
		}
		String view = "/WEB-INF/views/list.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}


}