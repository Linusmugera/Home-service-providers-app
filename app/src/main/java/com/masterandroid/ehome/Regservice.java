package com.masterandroid.ehome;

public class Regservice {
    private String firstname;
    private String lastname;
    private String email;
    private String serviceoffering;
    private String certnumber;
    private String identity;
    private String mobile;
    private String location;

    public Regservice() {
    }

    public Regservice(String firstname, String lastname, String email, String serviceoffering, String certnumber, String identity, String mobile, String location) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.serviceoffering = serviceoffering;
        this.certnumber = certnumber;
        this.identity = identity;
        this.mobile = mobile;
        this.location = location;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getServiceoffering() {
        return serviceoffering;
    }

    public void setServiceoffering(String serviceoffering) {
        this.serviceoffering = serviceoffering;
    }

    public String getCertnumber() {
        return certnumber;
    }

    public void setCertnumber(String certnumber) {
        this.certnumber = certnumber;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
