import java.util.*;

public class TemperaturaTest {

    static Scanner sc = new Scanner (System.in);
    public static void main (String args []){
        System.out.println("Inserisci i valori di temperatura e la scala (C o F).");
        int gradi = sc.nextInt();
        String scala = sc.next().trim();
        Temperatura temp1 = new Temperatura(gradi, scala);
        System.out.println(temp1.getCelsius() +" gradi Celsius.");
        System.out.println(temp1.getFahrenheit()+ " gradi Fahrenheit.");
    }
}