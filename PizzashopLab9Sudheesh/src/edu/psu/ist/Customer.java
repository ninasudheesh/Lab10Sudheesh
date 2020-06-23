/*
Project: Lab 10
Purpose Details: Pizza ordering application
Course: IST 242
Author: Nina Sudheesh
Date Developed: 6/11/2020
Last Date Changed: 6/22/2020
Revision: 3
 */
package edu.psu.ist;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer {
    //Class Level Variables - Protect the data
    private int customerId;
    private String customerName;
    private String customerPhoneNumber;

    //Constructor Method
    public Customer(int _customerId) {
        this.customerId = _customerId;  //Increments the ID count
    }

    //Setters and Getters customerid
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int _customerId) {
        this.customerId = _customerId;
    }

    //Setters and Getters customer name
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String _customerName) {
        this.customerName = _customerName;
    }

    //Setters and Getters customer phone
    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String _customerPhoneNumber) {
        this.customerPhoneNumber = _customerPhoneNumber;
    }


    public static void printCustomer(ArrayList<Customer> cList) {
        for (Customer cust : cList) {
            System.out.println("Customer Id:" + cust.getCustomerId());
            System.out.println("Customer Name:" + cust.getCustomerName());
            System.out.println("Customer Phone:" + cust.getCustomerPhoneNumber() +"\n");
        }
    }

}
