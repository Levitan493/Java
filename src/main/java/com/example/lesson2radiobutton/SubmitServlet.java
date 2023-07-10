package com.example.lesson2radiobutton;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "submitServlet", value = "/SubmitServlet")
public class SubmitServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        Integer option1Count = (Integer) session.getAttribute("option1Count");
        Integer option2Count = (Integer) session.getAttribute("option2Count");
        Integer option3Count = (Integer) session.getAttribute("option3Count");
        Integer option4Count = (Integer) session.getAttribute("option4Count");

        if (option1Count == null) {
            option1Count = 0;
        }
        if (option2Count == null) {
            option2Count = 0;
        }
        if (option3Count == null) {
            option3Count = 0;
        }
        if (option4Count == null) {
            option4Count = 0;
        }

        String technology = request.getParameter("technology");
        String salary = request.getParameter("salary");

        if (technology != null && !technology.isEmpty()) {
            if (technology.equals("option1")) {
                option1Count++;
            } else if (technology.equals("option2")) {
                option2Count++;
            }
        }

        if (salary != null && !salary.isEmpty()) {
            if (salary.equals("option3")) {
                option3Count++;
            } else if (salary.equals("option4")) {
                option4Count++;
            }
        }

        session.setAttribute("option1Count", option1Count);
        session.setAttribute("option2Count", option2Count);
        session.setAttribute("option3Count", option3Count);
        session.setAttribute("option4Count", option4Count);

        request.setAttribute("option1Count", option1Count);
        request.setAttribute("option2Count", option2Count);
        request.setAttribute("option3Count", option3Count);
        request.setAttribute("option4Count", option4Count);

        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }
}
