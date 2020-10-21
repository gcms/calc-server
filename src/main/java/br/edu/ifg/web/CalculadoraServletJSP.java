package br.edu.ifg.web;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

public class CalculadoraServletJSP extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int a = Integer.parseInt(req.getParameter("a"));
        int b = Integer.parseInt(req.getParameter("b"));

        req.setAttribute("soma", a + b);

        getServletContext().getRequestDispatcher("/jsp/calculadora/calc-view").include(req, resp);
        resp.setContentType("text/html");
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}
