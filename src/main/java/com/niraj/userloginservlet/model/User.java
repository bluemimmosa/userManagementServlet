/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niraj.userloginservlet.model;

import java.io.Serializable;

/**
 *
 * @author Niraj Khadka
 */
public class User implements Serializable {
    private int userId;
    private String userName;
    private String fullName;
    private String password;

    public User() {
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    
    public User(int userId, String userName, String fullName, String password) {
        this.userId = userId;
        this.userName = userName;
        this.fullName = fullName;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", userName=" + userName + ", fullName=" + fullName + ", password=" + password + '}';
    }
    
    
}
