import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.JOptionPane;

public class test extends JFrame {
    public static void main (String args[])
        {
            test gui = new test();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gui.setSize(200,200);
        gui.setVisible(true);
        gui.setTitle("chart-test");

     }

    }