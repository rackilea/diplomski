package forstaPakage;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        String str = "";

        while(true) {
            int f = Integer.parseInt(JOptionPane.showInputDialog( str + "\n" + "hur många farenheit?"));
            if(f>0 && f<101){
                int c =  ((f-32)*5) / 9;
                System.out.println(f + " farhenheit är lika med " + c + " celcius" );
                break;
            } else {
                str = "Ogiltligt värde, skriv in ett nytt";
            }
        }

    }
}