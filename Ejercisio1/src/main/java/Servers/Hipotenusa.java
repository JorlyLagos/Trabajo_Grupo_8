package Servers;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CalcularHipotenusa")
public class Hipotenusa extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 1. Obtener datos del formulario
        String catA = request.getParameter("catetoA");
        String catB = request.getParameter("catetoB");
        
        double a = Double.parseDouble(catA);
        double b = Double.parseDouble(catB);
        
        // 2. Calcular hipotenusa
        double c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
        
        // 3. Respuesta HTML con diseño limpio
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<style>");
        // Diseño ultra sencillo
        out.println("body { font-family: sans-serif; background-color: #f0f2f5; display: flex; justify-content: center; padding-top: 60px; }");
        out.println(".caja { background: white; padding: 30px; border-radius: 10px; box-shadow: 0 4px 6px rgba(0,0,0,0.1); text-align: center; width: 320px; }");
        out.println("h2 { color: #333; margin-bottom: 20px; }");
        out.println(".datos { text-align: left; background: #f9f9f9; padding: 10px; border-radius: 5px; margin-bottom: 15px; }");
        out.println(".resultado { font-size: 26px; color: #27ae60; font-weight: bold; }");
        out.println("a { text-decoration: none; color: #007bff; font-size: 14px; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        
        out.println("<div class='caja'>");
        out.println("<h2>Resultado</h2>");
        
        // Sección donde se muestran los catetos A y B
        out.println("<div class='datos'>");
        out.println("<b>Cateto A:</b> " + a + "<br>");
        out.println("<b>Cateto B:</b> " + b);
        out.println("</div>");
        
        out.println("<p>La hipotenusa es:</p>");
        out.println("<div class='resultado'>" + String.format("%.2f", c) + "</div>");
        
        out.println("<br><hr>");
        out.println("<br><a href='Hipotenusa.html'>Volver a calcular</a>");
        out.println("</div>");
        
        out.println("</body>");
        out.println("</html>");
    }
}