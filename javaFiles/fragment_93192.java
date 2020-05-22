package com.test.collection.list.vector.custom;

public class ClientCode {

    public static void main(String[] args) {
        CustomerVector custVectObj = new CustomerVector();
        // Add Customers
        custVectObj.createCustomer(1,"joan",10.03f);
        custVectObj.custDetails();
    }
}