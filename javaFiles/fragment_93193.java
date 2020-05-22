package com.test.collection.list.vector.custom;

public class ClientCode {

    public static void main(String[] args) {
        CustomerVector custVectObj = new CustomerVector();
        // Add Customers
        for(int i = 0; i < 1000; i++){
            custVectObj.createCustomer(i,"name"+i,i);
        }
        custVectObj.custDetails();
    }
}