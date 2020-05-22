import javax.swing.*;
import java.util.Random;

class Projekt_1
{
public static void main(String[] args) {
        final int maxTries = 5;
        JOptionPane.showMessageDialog(null, "Welcome... " + maxTries + " tries ... 500 krones ");

        final Random rnd = new Random();
        final int hemligtnummer = rnd.nextInt(20) + 1;
        int tryCounter = 0;
        final int pengar = 500;
        String nummer;

        int guess = -1;

        while (guess != hemligtnummer && tryCounter < maxTries) {
            if(tryCounter==0)
            nummer = JOptionPane.showInputDialog("...a number 1 and 20");
            else
            nummer = JOptionPane.showInputDialog("Enter no...");
            guess = Integer.parseInt(nummer);
            if (guess == hemligtnummer) {
                break;
            } else if (guess > hemligtnummer) {
                JOptionPane.showMessageDialog(null, "Try " + (tryCounter+1) + " was too big try a smaller one");
            } else if (guess < hemligtnummer) {
                JOptionPane.showMessageDialog(null, "Try " + (tryCounter+1) + " too small try a bigger one");
            }
            tryCounter++;
        }
        if(tryCounter==5){
            JOptionPane.showMessageDialog(null,"Grattis du vann!" + "\nteh number was " + hemligtnummer + "\nDet tog dig " + tryCounter + " försök");
            JOptionPane.showMessageDialog(null, "Your price is :" + (pengar - tryCounter * 100) + " Krones");
        }
        else
        {
            JOptionPane.showMessageDialog(null,"congrats you won"+"Your price is :" + (pengar - tryCounter * 100) + " Krones" );
        }
    }
}