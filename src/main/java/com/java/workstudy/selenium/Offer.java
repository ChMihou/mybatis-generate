package com.java.workstudy.selenium;

import java.io.Serializable;

public class Offer implements Serializable {

    private static final long serialVersionUID = 2288735996591764103L;

    private String cardNumber;

    private String LastName;

    private String name;

    private String year;

    private String month;

    private String day;

    private String cvv;

    private String postcode;

    private String country;

    private String city;

    private String email;

    private String phone;

    private String state;

    private String submit1;

    private String submit2;

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getLastName() {
        return LastName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getSubmit1() {
        return submit1;
    }

    public void setSubmit1(String submit1) {
        this.submit1 = submit1;
    }

    public String getSubmit2() {
        return submit2;
    }

    public void setSubmit2(String submit2) {
        this.submit2 = submit2;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Offer(String cardNumber, String lastName, String name, String year, String month, String cvv, String postcode, String country, String city, String email, String phone, String state) {
        this.cardNumber = cardNumber;
        this.LastName = lastName;
        this.name = name;
        this.year = year;
        this.month = month;
        this.cvv = cvv;
        this.postcode = postcode;
        this.country = country;
        this.city = city;
        this.email = email;
        this.phone = phone;
        this.state = state;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "cardNumber='" + cardNumber + '\'' +
                ", LastName='" + LastName + '\'' +
                ", name='" + name + '\'' +
                ", year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", day='" + day + '\'' +
                ", cvv='" + cvv + '\'' +
                ", postcode='" + postcode + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", state='" + state + '\'' +
                ", submit1='" + submit1 + '\'' +
                ", submit2='" + submit2 + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
