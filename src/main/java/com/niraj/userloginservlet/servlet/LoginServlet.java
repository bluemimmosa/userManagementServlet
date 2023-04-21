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
public class LoginServlet extends HttpServlet{
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException{
        String uName= req.getParameter("userName");
        String password = req.getParameter("password");
        User u = new User(uName, password);
        UserController uc = new UserController();
        if(uc.verifyUser(u)){
            RequestDispatcher rd = req.getRequestDispatcher("/dashboard.html");
            rd.forward(req, res);
        }else{
            res.setContentType("text/html");
            PrintWriter out = res.getWriter();
            out.println("<font color='RED'><center>The user doesnt exist.</center></font>");
            RequestDispatcher rd = req.getRequestDispatcher("/login.html");
            rd.include(req, res);
        }
    }
}
