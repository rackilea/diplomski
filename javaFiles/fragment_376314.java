package com.company;

import java.util.Scanner;

public class Coffee {
    public static void main(String[] args) {

        //I define the type of coffees as Strings, plus the order as String as well
        String espresso = "espresso";
        String americano = "americano";
        String cappuccino = "cappuccino";
        String latte = "latte";

        //I ask the user for their input
        Scanner choice = new Scanner(System.in);
        System.out.println("What kind of coffee would you like? We have: espresso, americano, cappuccino and latte");

        //depending on the user's choice, the corresponding name is displayed; if any other string is entered, the else clause is displayed

        String order = choice.next();
        if (order.equals(espresso)) {
            System.out.println("Your order: " + espresso);

        } else if (order.equals(americano)) {
            System.out.println("Your order: " + americano);

        } else if (order.equals(cappuccino)) {
            System.out.println("Your order: " + cappuccino);

        } else if (order.equals(latte)) {
            System.out.println("Your order: " + latte);

        } else {
            System.out.println("Unfortunately we can't serve you. Have a nice day!");
        }

    }
}