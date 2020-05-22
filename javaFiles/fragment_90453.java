import javax.swing.*;

/**
 * A2
 * @author Michael
 * @link https://stackoverflow.com/questions/30965862/calling-method-to-a-main-in-java
 * @since 6/21/2015 11:00 AM
 */
public class SimpleMathDemo {

    public static double hypotenuse(double a,double b) {
        return Math.sqrt(a*a+b*b);
    }

    public static void main(String[] args) {
        String text1= JOptionPane.showInputDialog("How long is side A? ");
        int x=Integer.parseInt(text1);
        String text2=JOptionPane.showInputDialog("How long is side B? ");
        int y=Integer.parseInt(text2);
        double c= SimpleMathDemo.hypotenuse(x,y);
        JOptionPane.showMessageDialog(null, "The hypotenuse of the triangle is " +c);
    }
}