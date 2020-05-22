import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Polygon;
import java.awt.TextField;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Keuze extends JFrame {
    ....
    public Keuze(){
        init();
    }

    public void init(){
        ....
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    ....
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                new Keuze();
            }
        });
    }
}