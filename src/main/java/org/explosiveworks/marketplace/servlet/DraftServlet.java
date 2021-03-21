package org.explosiveworks.marketplace.servlet;

import org.explosiveworks.marketplace.util.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DraftServlet", urlPatterns = "/draftServlet")
public class DraftServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter printWriter = response.getWriter();
        printWriter.print(getValue("https://marketplace-main.herokuapp.com/draftServlet"));
    }

    private String getValue(String address) {
        try {
            return Service.getValue(address);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "unknown exception";
    }
}
