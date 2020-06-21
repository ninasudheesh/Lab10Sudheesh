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


    public static Order addOrder(ArrayList<Menu> mList, ArrayList<Customer> cList,int orderCount) {
        Scanner sc = new Scanner(System.in);
        //Called getvalid id
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
            System.out.println("Select your Menu Options by their Menu Id then enter 0 to quit");
            menuid = sc.nextInt();

            if (menuid > 0) {
                selectedItems.add(mList.get(menuid - 1));
                System.out.println("Enter the quantity of your selected pizza");
                quantity = sc.nextInt();
                quantities.add(quantity);
            }
        } while (menuid > 0);
        order.setSelectedItems(selectedItems);
        order.setQuantities(quantities);
        return order;
    }

}
