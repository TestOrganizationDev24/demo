package ua.kpi.jakartaee.servlets;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.kpi.jakartaee.exceptions.PageNotFoundException;
import ua.kpi.jakartaee.exceptions.UserNotFoundException;
import ua.kpi.jakartaee.services.UserService;

import java.io.IOException;

@WebServlet(urlPatterns = "/users/*")
public class UserServlet extends HttpServlet {

    @Inject
    @Named("userServiceImpl")
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String pathInfo = req.getPathInfo();
            String pageName = userService.getUserPage(pathInfo);
            req.getRequestDispatcher(pageName).forward(req, resp);
        } catch (UserNotFoundException | PageNotFoundException e) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
