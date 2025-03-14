package ua.kpi.jakartaee.servlets;

import jakarta.annotation.security.RolesAllowed;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/library/guest/page")
@ServletSecurity(
        @HttpConstraint(rolesAllowed = {"GUEST", "ADMIN"})
)
public class GuestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        var a = req.getUserPrincipal();
        System.out.println(a);

        resp.setContentType("text/plain");
        PrintWriter out = resp.getWriter();
        out.println("Guest page");
    }
}
