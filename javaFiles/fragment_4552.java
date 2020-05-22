package oldMcDonald;

import javax.swing.JOptionPane;

public class MyAttempt {
    public static void main(String[] args) {
        callFirstLine();
        callEiEiO();
        System.out.println("And on his farm he had a cow, E-I-E-I-O,");
        System.out.println("With a moo-moo here and a moo-moo there");
        System.out.println("Here a moo, there a moo,");
        System.out.println("Everywhere a moo-moo.");
        callFirstLine();
        callEiEiO();
    }
    public static void callFirstLine(){
        System.out.println("Old McDonald had a farm,");
    }
    public static void callEiEiO() {
        String input = "";
        do{
        input = JOptionPane.showInputDialog("Please Enter 'EiEiO': ");
        }while (!"EiEiO".equals(input));
        System.out.println(input);
    }
}