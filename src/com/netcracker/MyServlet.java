package com.netcracker;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by glak0514 on 14.11.2017.
 */
@WebServlet("/authorization")
public class MyServlet extends HttpServlet {

    private static String message = "Hello from my first servlet";
    private static final String password="123456";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userName = req.getParameter("username");
        String userPassword = req.getParameter("password");

        PrintWriter pw = resp.getWriter();

        StringBuilder builder = new StringBuilder();

        builder.append("<html>");
        builder.append("<body>");

        if (userPassword.equals(password))
            builder.append("<h2> Hello, "+ userName+ "</br>");
        else {
            builder.append("<form name=\"loginForm\" method=\"GET\" action=\"login.html\">");
            builder.append("<p> Invalid password, press enter to return </p>");
            builder.append("<input type=\"submit\" value=\"Return\">");
            builder.append(" </form>");
        }

        builder.append("</body>");
        builder.append("</html>");

        pw.write(builder.toString());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
