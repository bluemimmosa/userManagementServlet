/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niraj.userloginservlet.servlet;

import com.niraj.userloginservlet.controller.UserController;
import com.niraj.userloginservlet.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 *
 * @author Niraj Khadka
 */
public class RegistrationServlet extends HttpServlet{
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException{
        String uName= req.getParameter("userName");
        String password = req.getParameter("password");
        int userId = Integer.parseInt(req.getParameter("userId"));
        String fullName = req.getParameter("fullName");
        User u = new User(userId, uName, fullName, password);
        UserController uc = new UserController();
        User addedUser = uc.addUser(u);
        if(addedUser != null){
            res.setContentType("text/html");
            PrintWriter out = res.getWriter();
            out.print("<font color='RED'><center>New User with userName <b>'"+addedUser.getUserName()+"'</b> added Successfully! Now please login.</center></font>");
            RequestDispatcher rd = req.getRequestDispatcher("/register.html");
            rd.include(req, res);
        }else{
            res.setContentType("text/html");
            PrintWriter out = res.getWriter();
            out.println("<font color='RED'><center>New user cannot be added due to duplicate userId or userName. Please change those parameters.</center></font>");
            RequestDispatcher rd = req.getRequestDispatcher("/register.html");
            rd.include(req, res);
        }
    }
}
