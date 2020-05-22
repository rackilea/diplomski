package com.DatingService;

class c{
    private int i;
    public void setI(int i){
        this.i=i;
    }
    public int getI(){
        return this.i;
    }
}

public class Main{
    public static void main(String[] args){
        c myCVariable = new c();

        myCVariable.setI(10);
        System.out.println(myCVariable.getI());
    }
}