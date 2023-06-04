package controller;

import service.PartnerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "PartnerServlet", value = "/partner")
public class PartnerServlet extends HttpServlet {
    private final PartnerService partnerService = PartnerService.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createGet(request, response);
                break;
            case "update":
                updateGet(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            default:
                findAdd(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createPost(request, response);
                break;
            case "update":
                updatePost(request, response);
                break;
            case "search":
                search(request, response);
        }
    }

    private void findAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/partner/home.jsp");
        request.setAttribute("partner", partnerService.findAll());
        requestDispatcher.forward(request, response);
    }

    private void createGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/partner/create.jsp");
    }

    private void createPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        partnerService.save(request);
        response.sendRedirect("/partner");
    }
    private void updateGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("partner_id"));
        if (partnerService.checkById(id)) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/partner/update.jsp");
            request.setAttribute("partner", partnerService.getById(id));
            requestDispatcher.forward(request, response);
        } else {
            response.sendRedirect("/404.jsp");
        }
    }
    private void updatePost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("partner_id"));
        if (partnerService.checkById(id)) {
            partnerService.save(request);
            response.sendRedirect("/partner");
        } else {
            response.sendRedirect("/404.jsp");
        }
    }
    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("partner_id"));
        if (partnerService.checkById(id)) {
            partnerService.deleteById(id);
            response.sendRedirect("/partner");
        } else {
            response.sendRedirect("/404.jsp");
        }
    }
    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("partner", partnerService.searchByName(request));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/partner/home.jsp");
        requestDispatcher.forward(request, response);
    }
}
