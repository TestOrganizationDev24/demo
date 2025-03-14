package ua.kpi.jakartaee.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getUserPrincipal() != null) {
            resp.sendRedirect("/library/home");
        } else {
            req.getRequestDispatcher("/WEB-INF/static/login.jsp").forward(req, resp);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            request.login(username, password);
            response.sendRedirect("/library/home");
        } catch (ServletException e) {
            System.out.println("ERROR: " + e.getMessage());
            response.sendRedirect("/login?error=true");
        }
    }
}
