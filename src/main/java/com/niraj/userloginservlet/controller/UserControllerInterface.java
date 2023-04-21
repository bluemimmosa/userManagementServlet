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
public interface UserControllerInterface {
    public User addUser(User user);
    public ArrayList<User> listAllUsers();
    public boolean verifyUser(User user);
}
