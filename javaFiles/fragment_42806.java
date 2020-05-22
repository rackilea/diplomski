package com.currency;
public class Yen extends Waehrung{

double wert;
private static double kurs;

public Yen(double wert){
    this.wert = wert;
}

public void setKurs(double kurs){
    this.kurs = kurs;
}

public double dollarBetrag(){
    return wert * kurs;
}
}