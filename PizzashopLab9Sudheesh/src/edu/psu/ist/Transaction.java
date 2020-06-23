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

enum PaymentType {cash, credit}

public class Transaction {

    //Class Level Variables - Protect the data
    private int transactionId;
    private Order order;
    private PaymentType pType;

    //Constructor Method
    public Transaction(int _transactionId, Order _order, PaymentType _pType) {
        this.transactionId = _transactionId;
        this.order = _order;
        this.pType = _pType;
    }

    //Setters and Getters transaction id
    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int _transactionId) {
        this.transactionId = _transactionId;
    }

    //Setters and Getters Order
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order _order) {
        this.order = _order;
    }


    //Setters and Getters payment type
    public PaymentType getPaymentType() {
        return pType;
    }

    public void setPaymentType(PaymentType _pType) {
        this.pType = _pType;
    }


    public static void listTransactions(ArrayList<Transaction> tList) {
        for (Transaction trans : tList) {
            System.out.println("Transaction ID: " + trans.getTransactionId());
            System.out.println("Order Id:" + trans.getOrder().getorderId());
            //Printed the Customer Information(ID,Name,and Phone)
            System.out.println("\n \tCustomer Information"+"\n Customer Id: "+trans.getOrder().getCustomer().getCustomerId()+"\n Customer Name: "+ trans.getOrder().getCustomer().getCustomerName()+"\n CustomerPhone: "+trans.getOrder().getCustomer().getCustomerPhoneNumber()+" \n");

            int i = 0;
            double total = 0.00;
            System.out.println("Pizza \t\t" + "Quantity \t\t" + " Price");

            for (Menu menu : trans.getOrder().getSelectedItems()) {
                System.out.println(menu.getmenuItem() + "\t\t\t" + trans.getOrder().getQuantities().get(i) + "\t\t\t"
                        + ((menu.getMenuPrice()) * (trans.getOrder().getQuantities().get(i))));
                total = total + menu.getMenuPrice() * trans.getOrder().getQuantities().get(i);
                i++;
            }
            //TODO: Print order
            System.out.println("Payment Type: " + trans.getPaymentType());
            System.out.println("Total Price: $" + total);

        }
    }

    public static PaymentType getTransactType() {
        Scanner sc = new Scanner(System.in);
        PaymentType tType = null;
        System.out.println("Are you going to pay with cash or credit?: ");
        String pType = sc.next();

        if (pType.equals("cash")) {
            tType = PaymentType.cash;
        } else if (pType.equals("credit")) {
            tType = PaymentType.credit;
        } else {
            System.out.println("Invalid Payment type");
        }
        return tType;
    }
}
