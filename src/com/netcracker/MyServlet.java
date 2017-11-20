package com.netcracker;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by glak0514 on 14.11.2017.
 */
@WebServlet("/mainForm")
public class MyServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        StringBuilder builder=new StringBuilder();

        builder.append("<html>");
        builder.append("<body>");
        builder.append("<form>");
        builder.append("Data/time: "+new Date().toString()+"</br>");
        builder.append("Browser: "+req.getHeader("user-agent")+"</br>");
        builder.append("<input type=\"submit\" value=\"Refresh\">");
        builder.append("</form>");
        builder.append("</body>");
        builder.append("</html>");



        PrintWriter pw = resp.getWriter();
        pw.write(builder.toString());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
