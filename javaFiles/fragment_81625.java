import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @author JayaPrasad
 * 
 */
public class SwingHtml {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JLabel label = new JLabel(
                "<html>Case &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Item&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; CaseNum<table><tr><font color=blue>Party1</font></tr><tr><font color=red>Party2</font></tr></table></html>");
        frame.add(label);
        frame.setSize(new Dimension(250, 130));
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}