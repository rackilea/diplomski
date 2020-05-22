import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class exp{
    public static void main(String args[]){
        Runnable r = new Runnable() {
            public void run() {
                JFrame jf=new JFrame("This is JFrame");
                JPanel h=new JPanel();
                // add more space around the panel!
                h.setBorder(new EmptyBorder(50,50,50,50));

                h.add(new JButton("Button"));
                h.add(new JLabel("this is JLabel"));
                h.setBackground(Color.RED);

                jf.add(h);
                jf.getContentPane().setBackground(Color.BLACK);
                jf.setLayout(new FlowLayout());

                jf.setVisible(true);
                jf.pack();
                jf.setMinimumSize(jf.getSize());
                jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}