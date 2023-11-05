
package com.backend.forumavalburo.models;

import java.util.ArrayList;


public class CommentModel {
 
    private int id;
    private UserModel user;
    private String message;
    private ArrayList<CommentModel> response;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<CommentModel> getResponse() {
        return response;
    }

    public void setResponse(ArrayList<CommentModel> response) {
        this.response = response;
    }
    
    
}
