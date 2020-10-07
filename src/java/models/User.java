/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lrandom
 */
public class User extends ConnectDB{
    public static final String TABLE_NAME ="users";
    
    public User() {
       connect();
    }
    
    
    public ArrayList<UserBean> getList(){
        try {
            this.sql = "SELECT * FROM "+TABLE_NAME;
            PreparedStatement prp = conn.prepareStatement(this.sql);
            ResultSet resultSet = prp.executeQuery();
            ArrayList<UserBean> users = new ArrayList<>();
            while(resultSet.next()){
               UserBean user = new UserBean();
               user.setId(resultSet.getInt("id"));
               user.setUsername(resultSet.getString("username"));
               user.setPass(resultSet.getString("password"));
               users.add(user);
            }
            return users;
        } catch (SQLException ex) {
           return null;
        }
    }
    
    
    public class UserBean{
        private int id;
        private String username;
        private String pass;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }


        public String getPass() {
            return pass;
        }

        public void setPass(String pass) {
            this.pass = pass;
        }  
    }
}
