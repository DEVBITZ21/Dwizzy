package com.example.devbitz.Model;

import java.util.List;

public class Request {
    private String phone;
    private String name;
    private String address;
    private String total;
    private List<Order> foods; // list of foods of order


    public Request() {

    }

    public Request(String phone, String name, String address, String total, List<Order> foods) {
        this.phone = phone;
        this.name = name;
        this.address = address;
        this.total = total;
        this.foods = foods;
    }

    public Request(String phone) {
        this.phone = phone;
    }
}
