package controller;

import service.OptionalService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "OptionalServlet", value = "/optional")
public class OptionalServlet extends HttpServlet {
    private final OptionalService optionalService = OptionalService.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private void findAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/optional/home.jsp");
        request.setAttribute("optional", optionalService.findAll());
        requestDispatcher.forward(request, response);
    }
    private void createGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/optional/create.jsp");
    }
    private void createPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        optionalService.save(request);
        response.sendRedirect("/optional");
    }
    private void updateGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int optional_id = Integer.parseInt(request.getParameter("optional_id"));
        if (optionalService.checkById(optional_id)) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/optional/update.jsp");
            request.setAttribute("optional", optionalService.getById(optional_id));
            requestDispatcher.forward(request, response);
        } else {
            response.sendRedirect("/404.jsp");
        }
    }
    private void updatePost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int optional_id = Integer.parseInt(request.getParameter("optional_id"));
        if (optionalService.checkById(optional_id)) {
            optionalService.save(request);
            response.sendRedirect("/optional");
        } else {
            response.sendRedirect("/404.jsp");
        }
    }
    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("optional_id"));
        if (optionalService.checkById(id)) {
            optionalService.deleteById(id);
            response.sendRedirect("/optional");
        } else {
            response.sendRedirect("/404.jsp");
        }
    }
}
