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

public class Menu {

    //Class Level Variables - Protect the data
    private int menuId;
    private String menuItem;
    private double menuPrice;

    //Constructor Method
    public Menu(int _menuId, String _menuItem, double _menuPrice) {
        this.menuId = _menuId;
        this.menuItem = _menuItem;
        this.menuPrice = _menuPrice;
    }

    //Setters and Getters menu id
    public int getmenuId() {
        return menuId;
    }

    public void setmenuId(int _menuId) {
        this.menuId = _menuId;
    }

    //Setters and Getters menu item
    public String getmenuItem() {
        return menuItem;
    }

    public void setmenuItem(String _menuItem) {
        this.menuItem = _menuItem;
    }

    // Setters and Getters menu Price
    public double getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(double _menuPrice) {
        this.menuPrice = _menuPrice;
    }


    public static void listMenu(ArrayList<Menu> mList) {
        for (Menu menu : mList) {
            System.out.println(menu.getmenuId() + "     " + menu.getmenuItem() + "      " + menu.getMenuPrice() + "    ");
        }
    }
}
