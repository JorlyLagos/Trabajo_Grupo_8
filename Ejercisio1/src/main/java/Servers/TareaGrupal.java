package Servers;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/TareaGrupal")
public class TareaGrupal extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public TareaGrupal() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirigir al HTML si intentan entrar directamente por URL
        response.sendRedirect("binarios.html");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String numero = request.getParameter("numero");
        String operacion = request.getParameter("operacion");
        String resultado = "";

        try {
            if ("binarioDecimal".equals(operacion)) {
                resultado = String.valueOf(Integer.parseInt(numero, 2));
            } else {
                resultado = Integer.toBinaryString(Integer.parseInt(numero));
            }
        } catch (Exception e) {
            resultado = "Error: El número no corresponde al formato seleccionado.";
        }

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body style='font-family: Arial; text-align: center; padding: 50px;'>");
        out.println("<hr style='width: 50%;'>");
        out.println("<h3>Resultado de la conversión:</h3>");
        out.println("<p style='font-size: 24px; color: blue;'><b>" + resultado + "</b></p>");
        out.println("<br><a href='binarios.html' style='text-decoration: none; background: #eee; padding: 10px; border-radius: 5px; color: black;'>Volver al formulario</a>");
        out.println("</body></html>");
    }
}
