package com.example.lesson2radiobutton;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet(name = "submitServlet", value = "/SubmitServlet")
public class SubmitServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        AtomicInteger option1Count = (AtomicInteger) session.getAttribute("option1Count");
        AtomicInteger option2Count = (AtomicInteger) session.getAttribute("option2Count");
        AtomicInteger option3Count = (AtomicInteger) session.getAttribute("option3Count");
        AtomicInteger option4Count = (AtomicInteger) session.getAttribute("option4Count");

        if (option1Count == null) {
            option1Count = new AtomicInteger(0);
        }
        if (option2Count == null) {
            option2Count = new AtomicInteger(0);
        }
        if (option3Count == null) {
            option3Count = new AtomicInteger(0);
        }
        if (option4Count == null) {
            option4Count = new AtomicInteger(0);
        }

        String technology = request.getParameter("technology");
        String salary = request.getParameter("salary");

        if (technology != null && !technology.isEmpty()) {
            if (technology.equals("option1")) {
                option1Count.incrementAndGet();
            } else if (technology.equals("option2")) {
                option2Count.incrementAndGet();
            }
        }

        if (salary != null && !salary.isEmpty()) {
            if (salary.equals("option3")) {
                option3Count.incrementAndGet();
            } else if (salary.equals("option4")) {
                option4Count.incrementAndGet();
            }
        }

        session.setAttribute("option1Count", option1Count);
        session.setAttribute("option2Count", option2Count);
        session.setAttribute("option3Count", option3Count);
        session.setAttribute("option4Count", option4Count);

        request.setAttribute("option1Count", option1Count.get());
        request.setAttribute("option2Count", option2Count.get());
        request.setAttribute("option3Count", option3Count.get());
        request.setAttribute("option4Count", option4Count.get());

        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }
}
