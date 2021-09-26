package com.example.devbitz.Model;

public class User {
    private String Name;
    private String Password;
    private String phone;


    public User() {
    }

    public User(String name, String password, String phone) {
        Name = name;
        Password = password;
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
