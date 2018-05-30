package com.example.david.minim2.Classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Coments {
    @SerializedName("user")
    @Expose
    private String user;

    @SerializedName("message")
    @Expose
    private String message;

    public Coments() {
    }

    @Override
    public String toString() {
        return "Coments{" +
                "user='" + user + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
