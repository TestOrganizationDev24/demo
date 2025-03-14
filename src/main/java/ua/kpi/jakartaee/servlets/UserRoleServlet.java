package ua.kpi.jakartaee.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user-role")
public class UserRoleServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();

        if (request.getUserPrincipal() != null) {
            String username = request.getUserPrincipal().getName();
            out.println("User: " + username);

            if (request.isUserInRole("ADMIN")) {
                out.println("Role: ADMIN");
            } else if (request.isUserInRole("GUEST")) {
                out.println("Role: GUEST");
            } else {
                out.println("Role: UNKNOWN");
            }
        } else {
            out.println("User is not logged in.");
        }
    }
}
