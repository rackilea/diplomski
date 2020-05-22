package com.currency;
public class UsDollar extends Waehrung {
    private double wert;

    public UsDollar(double wert){
        this.wert = wert;
    }

    public double dollarBetrag(){
        return wert;
    }
}