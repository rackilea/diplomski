import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Kalkulator {

    public Component getGUI() {
        // layout padding
        int p = 10;
        // the GUI as seen by the user (without frame)
        JPanel gui = new JPanel(new BorderLayout(p,p));
        gui.setBorder(new EmptyBorder(8, 8, 8, 8));

        JTextField tf = new JTextField(10);
        tf.setFont(tf.getFont().deriveFont(22f));
        gui.add(tf, BorderLayout.PAGE_START);

        JLabel l = new JLabel("Crafted with Luv - by monsters");
        gui.add(l, BorderLayout.PAGE_END);

        JPanel lhs = new JPanel(new BorderLayout(p,p));
        gui.add(lhs, BorderLayout.CENTER);

        JPanel numpad = new JPanel(new GridLayout(3,3,p,p));
        lhs.add(numpad, BorderLayout.CENTER);
        for (int ii=1; ii<10; ii++) {
            numpad.add(new JButton("" + ii));
        }
        JPanel extraButtons = new JPanel(new GridLayout(0,1,p,p));
        lhs.add(extraButtons, BorderLayout.PAGE_END);
        extraButtons.add(new JButton("0"));
        extraButtons.add(new JButton("Reset"));

        JPanel rhs = new JPanel(new GridLayout(0,1,p,p));
        rhs.add(new JButton("plus"));
        rhs.add(new JButton("Kurang"));
        rhs.add(new JButton("BAGI"));
        rhs.add(new JButton("kali"));
        rhs.add(new JButton("(HASIL)"));
        gui.add(rhs, BorderLayout.LINE_END);

        return gui;
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                Kalkulator k = new Kalkulator();   

                JFrame f = new JFrame("Kalkulator");
                f.add(k.getGUI());
                // Ensures JVM closes after frame(s) closed and
                // all non-daemon threads are finished
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                // See http://stackoverflow.com/a/7143398/418556 for demo.
                f.setLocationByPlatform(true);

                // ensures the frame is the minimum size it needs to be
                // in order display the components within it
                f.pack();
                // should be done last, to avoid flickering, moving,
                // resizing artifacts.
                f.setVisible(true);
            }
        };
        // Swing GUIs should be created and updated on the EDT
        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency/initial.html
        SwingUtilities.invokeLater(r);
    }
}