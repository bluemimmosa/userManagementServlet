/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niraj.userloginservlet.controller;

import com.niraj.userloginservlet.model.User;
import java.util.ArrayList;

/**
 *
 * @author Niraj Khadka
 */
public class UserController implements UserControllerInterface {

    @Override
    public User addUser(User user) {
        return new User(1,"niraj", "niraj", "hehek");
    }

    @Override
    public ArrayList<User> listAllUsers() {
        return null;
    }

    @Override
    public boolean verifyUser(User user) {
        return true;
    }
    
}
