/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niraj.userloginservlet.controller;

import com.niraj.userloginservlet.model.User;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Niraj Khadka
 */
public class UserController implements UserControllerInterface {
    DBController dbConn;
    
    public UserController() {
        dbConn = new DBController("jdbc:mysql://localhost:3306/primecollege", "root", "root");
    }

    @Override
    public User addUser(User user) {
        String query = "INSERT INTO `primecollege`.`users` (`userId`, `userName`, `fullName`, `password`) VALUES ('"+user.getUserId()+"', '"+user.getUserName()+"', '"+user.getFullName()+"', '"+user.getPassword()+"');";
        int res = dbConn.iud(query);
        if(res>0){
            return user;
        }
        return null;
    }

    @Override
    public ArrayList<User> listAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        String query = "SELECT * FROM users;";
        ResultSet rs = dbConn.select(query);
        try{
            while(rs.next()){
                User u = new User(rs.getInt("userId"), rs.getString("userName"), rs.getString("fullName"), rs.getString("password"));
                users.add(u);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public boolean verifyUser(User user) {
        String query = "SELECT * FROM users WHERE userName='"+user.getUserName()+"';";
        ResultSet rs = dbConn.select(query);
        try{
            if(rs.next()){
                if(rs.getString("userName").equals(user.getUserName()) && rs.getString("password").equals(user.getPassword())){
                    return true;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
}
