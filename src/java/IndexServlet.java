/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import controllers.UserController;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lrandom
 */
public class IndexServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet IndexServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet IndexServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String params = request.getParameter("c");
        
      
        ArrayList<String> controllerAction = new ArrayList<>();
        for (StringTokenizer stringTokenizer = new StringTokenizer(params,"/"); stringTokenizer.hasMoreTokens();) {
            String token = stringTokenizer.nextToken();
            controllerAction.add(token);
        }
        
        String controllerName = controllerAction.get(0);
        String actionName = controllerAction.get(1);
        controllerName = convertControllerName(controllerName)+"Controller";
        //UserController
        //response.getWriter().print(controllerName);
        try {
           Class<?> className = Class
                   .forName("controllers."+controllerName);
           Object obj = className.newInstance();
           Method method =
                        obj.getClass()
                       .getDeclaredMethod(actionName, 
                               HttpServletRequest.class
                               ,HttpServletResponse.class);
           
           //UserController userController = new UserController();
           
          //userController.index(request,response);
           
           method.invoke(obj, request, response);
        } catch (Exception ex) {
            response.getWriter().print(ex.getMessage());
           ex.printStackTrace();
        }
    }
    
    private String convertControllerName(String name){
      char[] temp = name.toCharArray();
      temp[0] = (char) ((int) temp[0] - 32);
      return new String(temp);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
