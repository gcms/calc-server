package br.edu.ifg.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CalculadoraServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int a = Integer.parseInt(req.getParameter("a"));
        int b = Integer.parseInt(req.getParameter("b"));

        HttpSession session = req.getSession();
        Object count = session.getAttribute("count");
        if (count != null) {
            count = ((Integer) count) + 1;
        } else {
            count = (Integer) 1;
        }
        session.setAttribute("count", count);


        PrintWriter out = resp.getWriter();
        out.printf("<h1>Servlet</h1>\n");
        out.printf("<b>O resultado é %d</b>\n", a + b);
        out.printf("<p>%d acessos</p>\n", count);
        out.printf("<p>Hoje é %s</p>\n", new java.util.Date());


        out.printf("<p>METHOD: %s</p>\n", req.getMethod());
        for (String header : Collections.list(req.getHeaderNames())) {
            out.printf("<p>%s: %s</p>\n", header, req.getHeader(header));
        }

        resp.setContentType("text/html");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req, resp);
    }

}