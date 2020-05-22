import javax.swing.*;
import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Hil0 {
    public static void main(String[]args) throws IOException {   

    List<String> highscore = new LinkedList<String>(Arrays.asList());
    int count = 0; // put it here instead 

    while(true) {

     String namn = JOptionPane.showInputDialog(null, "Välj namn");
       int a = Integer.parseInt(JOptionPane.showInputDialog(null, "Mellan       0 och vilket tal vill du gissa?"));         

     int slumptal = 1 + (int)(Math.random()*a);
     int counter = 0; 
    // int count = 0; move it out of while

     count++;
     String output = "";

     while(true) {         
     counter++;   

        String inputStr = JOptionPane.showInputDialog(null, "Gissa vilket tal (0-" + a +")");
        int input = Integer.parseInt(inputStr);

        if(input < slumptal) {
        JOptionPane.showMessageDialog(null, "Talet: " + input + " är för litet");      
        }
        else if(input > slumptal) {
        JOptionPane.showMessageDialog(null, "Talet: " + input + " är för stort");    
        }
        else if(input == slumptal) {
           highscore.add(namn + " " + counter + " gissningar" + " (0-" + a + ")");

           JOptionPane.showMessageDialog(null, "Rätt!" + "\n" + 
                                               "Antal gissningar: " + 
                                               counter);                                                                                                 

           String janej = JOptionPane.showInputDialog(null, "Vill du spela igen?");

           if(janej.equalsIgnoreCase("ja")) {
              break;               
           }
           else if(janej.equalsIgnoreCase("nej")) {
              for(int i = 0; i < count; i++) { // use < insetad of <= because you count from 0
              output += highscore.get(i) + "\n";
              }
              JOptionPane.showMessageDialog(null,"Resultat:" + "\n\n" + output);
              System.exit(0);              
           }                                                                                              
        }
     }
  }    
 } 
}