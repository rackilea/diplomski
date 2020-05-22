import javax.swing.*;
import java.net.*;
public class Train {
    public static void main(String[] args) {
        try {
        URL url = new URL("http://www.google.com");
        ImageIcon icon = new ImageIcon(new URL("https://upload.wikimedia.org/wikipedia/commons/d/d4/Wikipedesketch1.png"));
        Integer miles = Integer.parseInt(JOptionPane.showInputDialog("Enter the miles"));
        Double gallons = Double.parseDouble(JOptionPane.showInputDialog("Enter the gallons"));  
        Double mpg = miles / gallons;
        JOptionPane.showMessageDialog(null, "Miles per gallon is " + mpg, "Gass Mileage", JOptionPane.PLAIN_MESSAGE, icon);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}