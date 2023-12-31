package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getAttribute("message") == null) {
			request.setAttribute("message", "todoを管理しましょ");
		}
		
		int postId = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String priority = request.getParameter("upup");
		
		
		String url = "jdbc:mysql://localhost/todo";
		String user = "root";
		String password = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String sql = "UPDATE posts SET title = ?, content = ?, priority = ? WHERE id = ?";
		try (Connection connection = DriverManager.getConnection(url,user,password);
		PreparedStatement statement =connection.prepareStatement(sql);
		){
			statement.setString(1, title);
			statement.setString(2, content);
			statement.setString(3, priority);
			statement.setInt(4, postId);
			int number = statement.executeUpdate();
			request.setAttribute("message", "ID" + postId + "の更新ができました。");
			
		} catch (Exception e) {
			request.setAttribute("message", "Exception:" + e.getMessage());
		}
		
		String forward = "/show?id + postId";
		RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
		dispatcher.forward(request, response);
	}


}