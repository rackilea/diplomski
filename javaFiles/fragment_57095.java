package com.demo;

public class Sample {
    public static void print(String msg){
        System.out.println(msg);
    }

}


package com.demo;

public class Test {

    static{
        Sample.print("Invokes Before Main ...");
    }
    public static void main(String[] args) {
        System.out.println("Inside Main ....");

    }

}