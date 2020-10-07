/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.User;

/**
 *
 * @author Lrandom
 */
public class UserController {
    public void index(HttpServletRequest request, HttpServletResponse response){
        User user = new User();
        request.setAttribute("users", user.getList());
        ArrayList<User.UserBean> userBeans =  user.getList();
        
        try {
//            response.getWriter().write(userBeans.get(0).getUsername());
//            for (User.UserBean userBean : userBeans) {
//                res
//                response.getWriter().write(userBean.getUsername());
//            }
            request.getRequestDispatcher("WEB-INF/users/index.jsp")
                    .forward(request, response);
            //response.getWriter().print("Tes");
        } catch (Exception ex) {
            
        }
    }
}
