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

public class Lab9Sudheesh {
    int cCount = 1;

    public static void main(String[] args) {

        Lab9Sudheesh main = new Lab9Sudheesh();
        int transCount = 1;
        //Added a count for the orderId
        int orderCount = 1;

        final char EXIT_CODE = 'E';
        final char CUST_CODE = 'C';
        final char MENU_CODE = 'M';
        final char ORDE_CODE = 'O';
        final char TRAN_CODE = 'T';
        final char CUST_PRNT = 'P';
        final char HELP_CODE = '?';
        char userAction;
        final String PROMPT_ACTION = "Add 'C'ustomer, 'P'rint Customer, List 'M'enu, Add 'O'rder, List 'T'ransaction or 'E'xit: ";
        ArrayList<Customer> cList = new ArrayList<>();
        ArrayList<Menu> mList = new ArrayList<>();
        ArrayList<Order> oList = new ArrayList<>();
        ArrayList<Transaction> tList = new ArrayList<>();

        //Order order1 = new Order(1);
        //Transaction trans1 = new Transaction(1, order1, PaymentType.cash);
        Menu menu1 = new Menu(1, "Plain", 5.00);
        Menu menu2 = new Menu(2, "Meat", 6.00);
        Menu menu3 = new Menu(3, "Extra Cheese", 6.00);
        Menu menu4 = new Menu(4, "Veg", 6.00);

        mList.add(menu1);
        mList.add(menu2);
        mList.add(menu3);
        mList.add(menu4);

        //oList.add(order1);
        //tList.add(trans1);

        userAction = getAction(PROMPT_ACTION);

        while (userAction != EXIT_CODE) {
            switch (userAction) {
                case CUST_CODE:
                    cList.add(main.addCustomer());
                    break;
                case CUST_PRNT:
                    Customer.printCustomer(cList);
                    break;
                case MENU_CODE:
                    Menu.listMenu(mList);
                    break;
                case ORDE_CODE:
                    //Order.addOrders();
                    //New Modification of the Parameters
                    Order order = Order.addOrder(mList,cList,orderCount);
                    PaymentType paymentType = Transaction.getTransactType();
                    oList.add(order);
                    Transaction transaction = new Transaction(transCount++, order, paymentType);
                    tList.add(transaction);
                    break;
                case TRAN_CODE:
                    Transaction.listTransactions(tList);
                    break;
            }

            userAction = getAction(PROMPT_ACTION);
        }
    }

    public static char getAction(String prompt) {
        Scanner scnr = new Scanner(System.in);
        String answer = "";
        System.out.println(prompt);
        answer = scnr.nextLine().toUpperCase() + " ";
        char firstChar = answer.charAt(0);
        return firstChar;
    }

    public Customer addCustomer() {
        Customer cust = new Customer(cCount++);
        Scanner scnr = new Scanner(System.in);
        System.out.println("Please Enter your Name: ");
        cust.setCustomerName(scnr.nextLine());
        System.out.println("Please Enter your Phone: ");
        cust.setCustomerPhoneNumber(scnr.nextLine());
        return cust;
    }


}
