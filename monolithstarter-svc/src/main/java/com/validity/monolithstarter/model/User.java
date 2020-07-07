package com.validity.monolithstarter.model;

import com.opencsv.bean.CsvBindByName;

public class User {

    @CsvBindByName
    int id;

    @CsvBindByName(column = "first_name")
    String firstName;

    @CsvBindByName(column = "last_name")
    String lastName;

    @CsvBindByName
    String company;

    @CsvBindByName
    String email;

    @CsvBindByName
    String address1;

    @CsvBindByName
    String address2;

    @CsvBindByName
    String zip;

    @CsvBindByName
    String city;

    @CsvBindByName(column = "state_long")
    String stateLong;

    @CsvBindByName
    String state;

    @CsvBindByName
    String phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateLong() {
        return stateLong;
    }

    public void setStateLong(String stateLong) {
        this.stateLong = stateLong;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
