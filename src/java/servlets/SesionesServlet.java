/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author estel
 */
@WebServlet(name = "SesionesServlet", urlPatterns = {"/SesionesServlet"})
public class SesionesServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sesion=request.getSession();
        String titulo=null;
        
        //Pedimos el atributo y verificamos si existe
        Integer contadorVisitas=(Integer) sesion.getAttribute("contadorVisitas");
        
        //Si es igual a nulo, quiere decir que es la primera vez que accede:
        if(contadorVisitas==null){
            contadorVisitas=new Integer(1);
            titulo="Bienvenido por primera vez...";
        }else{
            //Si es distinto a nulo, incrementamos el contador:
            titulo="Bienvenido Nuevamente";
            contadorVisitas+=1;
        }
        
        //En cualquier caso, agregamos el valor del contador a la sesion:
        //hashMap, llave y un valor:
        sesion.setAttribute("contadorVisitas",contadorVisitas);
        //Mostramos los valores en el cliente
       
        PrintWriter out = response.getWriter();
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SesionesServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Http Session desde Servlet</h1>");
            out.println("<h2>Titulo: "+titulo+"</h2>");
            out.println("<br>");
            out.println("<p>Nro de accesos al recurso: "+contadorVisitas);
            out.println("<br>");
            out.println("<br>");
            out.println("<p>ID de la sesión: "+sesion.getId());
            out.println("</body>");
            out.println("</html>");
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   
    

}
