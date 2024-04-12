package org.example.lb1servlet;

import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private final String[] natureImages = {"img/trees/green.jpg", "img/trees/old.jpg", "img/trees/orange.jpg", "img/trees/park.jpg", "img/trees/yellow.jpg"};
    private final String[] carsImages = {"img/cars/blue.jpg", "img/cars/bmw.jpg", "img/cars/old.jpg", "img/cars/porshe.jpg", "img/cars/purple.jpg"};
    private final String[] animalsImages = {"img/animals/babychicks.jpg", "img/animals/elefant.jpg", "img/animals/gepard.jpg", "img/animals/redpanda.jpg", "img/animals/tiger.jpg"};

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String category = request.getParameter("category");
        int number = Integer.parseInt(request.getParameter("number"));

        String imageSrc = getImageSrc(category, number);

        // Передаем путь к изображению на новую JSP-страницу
        request.setAttribute("imageSrc", imageSrc);
        request.getRequestDispatcher("/imageDisplay.jsp").forward(request, response);
    }

    private String getImageSrc(String category, int number) {
        switch (category) {
            case "trees":
                return natureImages[number];
            case "cars":
                return carsImages[number];
            case "animals":
                return animalsImages[number];
            default:
                return null; // Возвращаем null, если категория не распознана
        }
    }
}