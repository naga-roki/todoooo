package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/welcome")
public class WelcomeController extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");

      
        if (username != null) {
            req.setAttribute("username", username);
            String view = "/WEB-INF/views/welcome.jsp";
            req.getRequestDispatcher(view).forward(req, res);
        } else {
            // ログインできていない場合、ログイン画面に移動
            res.sendRedirect("login");
        }
    }
}
