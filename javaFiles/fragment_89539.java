import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;

    /**
     * @author Rakesh KR
     */

public class SimpleGUI1 {



    public static void main(String[] args) {
        SimpleGUI1 gUI = new SimpleGUI1();
        gUI.action();
    }

    void action(){
        JFrame  frame  = new JFrame();
        JLabel label = new JLabel("രാകേഷ്");
        // Can also use unicode 
        //JLabel label= new JLabel("\u0d30\u0d3e\u0d15\u0d47\u0d37\u0d4d");
        Font font = new Font("Arial Unicode MS", Font.PLAIN, 12);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        label.setFont(font);
        frame.add(label);
        frame.setSize(100,100);
        frame.setVisible(true);

    }


}