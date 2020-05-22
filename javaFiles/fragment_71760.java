import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.*;

        public class Caine extends JFrame{
        //the pictures
        ImageIcon guy = new ImageIcon("tester.gif");
        JLabel pn = new JLabel(guy);
        JPanel panel = new JPanel();

        Caine(){
            super("Photuris Lucicrescens");

            //Important
            setSize(700,600);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            add(panel);
            setVisible(true);
            JLabel im = new JLabel(new ImageIcon("iconImage.gif"));
            setIconImage(customIcon);
            panel.add(im);
            add(pn);
        }
        }