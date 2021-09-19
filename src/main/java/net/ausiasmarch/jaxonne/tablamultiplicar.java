
package net.ausiasmarch.jaxonne;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class tablamultiplicar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            Integer alto = Integer.parseInt(request.getParameter("alto"));
            Integer ancho = Integer.parseInt(request.getParameter("ancho"));
            Integer max = 30;
            if (ancho == null || ancho > max || ancho < 1 || alto == null || alto > max || alto < 1) {
                out.print("<div class=\"p-5 mb-4\">");
                out.print("<div class=\"text-center\">");
                out.print("<h6 class=\"text-muted text-monospace\">Datos alto y ancho erroneos:</h6>");
                out.print("<h6 class=\"text-muted text-monospace\">Por favor introduce valores de ancho y alto entre 1 y " + max + "</h6>");
                out.print("</div>");
                out.print("</div>");
            } else {
                out.println("<table class=\"table table-bordered table-success table-striped mx-auto mt-5\" style=\"width: 500px;\" id=\"tabla\">");
                Integer i, j;
                for (i = 1; i <= alto; i++) {
                    out.println("<tr>");
                    for (j = 1; j <= ancho; j++) {
                        out.println("<td class=\"text-center\">");
                        Integer resultado = i * j;
                        out.println(resultado.toString());
                        out.println("</td>");
                    }
                    out.println("</tr>");
                }
                out.println("</table>");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Procesa el cuadrante de multiplicaciones";
    }

}
