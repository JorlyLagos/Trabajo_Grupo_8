package Servers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/numeros")
public class NumerosServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            // A y B: Obtener los 3 números enteros
            int n1 = Integer.parseInt(request.getParameter("n1"));
            int n2 = Integer.parseInt(request.getParameter("n2"));
            int n3 = Integer.parseInt(request.getParameter("n3"));

            int mayor = Math.max(n1, Math.max(n2, n3));
            int menor = Math.min(n1, Math.min(n2, n3));

            // C: Encontrar el valor que más se repite de "n" números
            String listaTexto = request.getParameter("lista");
            String[] arrayNumeros = listaTexto.split(",");
            Map<Integer, Integer> contador = new HashMap<>();

            for (String s : arrayNumeros) {
                int num = Integer.parseInt(s.trim());
                contador.put(num, contador.getOrDefault(num, 0) + 1);
            }

            int masRepetido = 0;
            int maxFrecuencia = 0;
            for (Map.Entry<Integer, Integer> entry : contador.entrySet()) {
                if (entry.getValue() > maxFrecuencia) {
                    maxFrecuencia = entry.getValue();
                    masRepetido = entry.getKey();
                }
            }

            // Generar la respuesta HTML
            out.println("<!DOCTYPE html>");
            out.println("<html><head><title>Resultados de Operación</title>");
            out.println("<style>table { border-collapse: collapse; width: 60%; margin-top: 20px; } ");
            out.println("th, td { border: 1px solid #333; padding: 12px; text-align: left; } ");
            out.println("th { background-color: #f4f4f4; }</style></head><body>");
            
         
            out.println("<table>");
            out.println("<tr><th>Descripción</th><th>Resultado</th></tr>");
            out.println("<tr><td><b>Mayor de los 3 números</b></td><td>" + mayor + "</td></tr>");
            out.println("<tr><td><b>Menor de los 3 números</b></td><td>" + menor + "</td></tr>");
            out.println("<tr><td><b>Número más repetido de la lista</b></td><td>" + masRepetido + " (aparece " + maxFrecuencia + " veces)</td></tr>");
            out.println("</table>");

            // Botón solicitado: Realizar otro cálculo
            out.println("<br><br>");
            out.println("<a href='Numeros.html' style='display: inline-block; padding: 10px 20px; background-color: #007BFF; color: white; text-decoration: none; border-radius: 5px;'>Realizar otro cálculo</a>");
            
            out.println("</body></html>");

        } catch (Exception e) {
            out.println("<h3>Error en los datos ingresados. Asegúrese de usar números y separar la lista con comas.</h3>");
            out.println("<a href='Numeros.html'>Volver al formulario</a>");
        }
    }
}