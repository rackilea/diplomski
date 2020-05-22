package NewAppIdea;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


    public class PictureSplash extends JFrame {

        private static final long serialVersionUID = 1L;
        JLabel l1;

        PictureSplash(){
        setTitle("Pic");
        setSize(400,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("C:\\Users\\Harry\\Desktop\\LearnJava\\pug-image3.jpg")));
        setLayout(new FlowLayout());
        setSize(399,399);
        setSize(400,400);
        }

        public static void main(String args[]) {
            new PictureSplash();
        }   
    }