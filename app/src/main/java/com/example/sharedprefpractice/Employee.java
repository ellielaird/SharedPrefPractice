package com.example.sharedprefpractice;

import java.util.ArrayList;

public class Employee {

    private String firstName;
    private int age;
    private String mail;

    private Address address;

    private ArrayList<FamilyMember> family;

    public Employee(String firstname, int age, String mail, Address address, ArrayList<FamilyMember> family){
        this.firstName = firstName;
        this.age = age;
        this.mail = mail;
        this.address = address;
        this.family = family;
    }

}