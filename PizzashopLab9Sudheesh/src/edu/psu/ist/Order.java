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

public class Order {
    //Class Level Variables - Protect the data
    private int orderId;
    private Customer customer;
    private ArrayList<Menu> selectedItems;
    private ArrayList<Integer> quantities;

    //Constructor Method
    public Order(int _orderId,Customer customer) {
        this.orderId = _orderId;
        this.customer = customer;
    }

    //Setters and Getters orderid
    public int getorderId() {
        return orderId;
    }

    public void setorderId(int _orderId) {
        this.orderId = _orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ArrayList<Menu> getSelectedItems() {
        return selectedItems;
    }

    public void setSelectedItems(ArrayList<Menu> selectedItems) {
        this.selectedItems = selectedItems;
    }

    public ArrayList<Integer> getQuantities() {
        return quantities;
    }

    public void setQuantities(ArrayList<Integer> quantities) {
        this.quantities = quantities;
    }


    //Added a Method check if Id is Valid
    public static boolean isValidCustomer(int id, ArrayList<Customer> cList) {
        for (Customer cus : cList) {
            if (id == cus.getCustomerId()) {
                return true;
            }
        }
        return false;
    }
    //Added method getCustomers
    public static Customer getCustomers(int id,ArrayList<Customer> cList){
        for(Customer cus : cList){
            //if id is correct return customer object
            if( id == cus.getCustomerId()){
                return cus;
            }
        }return null;
    }
    //Added method to Get a Customer with valid id
    public static int getValidCustomer(ArrayList<Customer> cList) {
        System.out.println("Enter Valid Customer Id: ");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        //Call method to check if valid id
        boolean valid = isValidCustomer(id, cList);
        do {
            if (!valid) {
                //if its false loop through till Valid id
                System.out.println("Invalid ID");
                System.out.println("Enter Valid Customer Id: ");
                id = sc.nextInt();
                valid = isValidCustomer(id,cList);
            } else {
                System.out.println("Valid ID");
            }

        } while (!valid);

        return id;
    }

    //Added a Method check if menu item Id is Valid
    public static boolean isValidMenuItem(int id,ArrayList<Menu> mList){
        for(Menu menus:mList){
            if(id == menus.getmenuId()){
                return true;
            }
        }
        return false;
    }
    //Added a Method to get a Valid menu item
    public static int getValidMenuItem(ArrayList<Menu> mList){
        System.out.println("Select your Menu Options by their Menu Id then enter 0 to quit");
        Scanner sc = new Scanner(System.in);
        int menuid = sc.nextInt();
        if (menuid == 0){
            return 0;
        }
        //Call method to check if menu item is valid
        boolean valid  = isValidMenuItem(menuid,mList);
        //Loop through check if not valid
        do{
            if(!valid){
                //If its false loop through till get Valid id
                System.out.println("Invalid Pizza Menu Item ID");
                System.out.println("Enter Valid Menu Item Id: ");
                menuid = sc.nextInt();
                valid = isValidMenuItem(menuid,mList);
            }
            else{
                System.out.println("Valid Menu Item ID");
            }

        }while(!valid);
        return menuid;
    }
    //Added a method to get valid Quantity/Quantities of Pizza Menu Items.
    public static int getValidQuantity(){
        Scanner sc = new Scanner(System.in);
        int quantity;
        do{
            System.out.println("Enter the quantity of your selected pizza");
            quantity = sc.nextInt();
            if (quantity >= 0){
                return quantity;
            }
            else{
                System.out.println("Invalid Quantity of Pizza(s)");
            }
        }while(quantity < 0);
        return quantity;
    }

    public static Order addOrder(ArrayList<Menu> mList, ArrayList<Customer> cList,int orderCount) {
        Scanner sc = new Scanner(System.in);
        //Called getValid id
        int customerid = getValidCustomer(cList);
        //Called getCustomer
        Customer cust = getCustomers(customerid,cList);
        Order order = new Order(orderCount++,cust);

        ArrayList<Menu> selectedItems = new ArrayList<Menu>();
        ArrayList<Integer> quantities = new ArrayList<>();
        Menu.listMenu(mList);
        int menuid;
        int quantity;
        do {
            //Called method to get a valid menu id
            menuid = getValidMenuItem(mList);
            if (menuid > 0) {
                selectedItems.add(mList.get(menuid - 1));
                //Called Method to get a valid quantity
                quantity = getValidQuantity();
                quantities.add(quantity);
            }
        } while (menuid > 0);
        order.setSelectedItems(selectedItems);
        order.setQuantities(quantities);
        return order;
    }

}
