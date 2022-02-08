package com.masterandroid.ehome;

import android.widget.ListView;

public class Clients {

    private String service;
    private String location;
    private String street;
    private String mobile;
    private String identity;
    private String payment_mode;


    public Clients() {
    }

    public Clients(String service, String location, String street, String mobile, String identity, String payment_mode ) {
        this.service = service;
        this.location = location;
        this.street = street;
        this.mobile = mobile;
        this.identity = identity;
        this.payment_mode = payment_mode;


    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getPayment_mode() {
        return payment_mode;
    }

    public void setPayment_mode(String payment_mode) {
        this.payment_mode = payment_mode;
    }


}