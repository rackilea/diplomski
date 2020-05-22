import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class  quiz {
    public static void main(String[] args) {
        String name, allname, loopname;
        int names, allnames, op, loopsname;
        int arValues[];

        name = JOptionPane.showInputDialog(null, "Enter how many friends names you would like ot enter");
        names = Integer.parseInt(name);
        arValues = new int[value];

        for (int i = 0; i < names; i++) {
            loopname = JOptionPane.showInputDialog(null, "Enter your friend's name");
            loopnames = Integer.parseInt(loopname);
            arValues[i] = loopnames;
        }

        allname = JOptionPane.showInputDialog(null, "Enter the number of which friend you want to see");
        allnames = Integer.parseInt(allname);
        op = arValues[allnames];
    }

    public static void finish() {
        System.exit(0);
    }
}