import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class EmptyBorderShowCase extends JFrame{

private static final long serialVersionUID = 1L;

public EmptyBorderShowCase(){
    JPanel displayPanel = new JPanel(new FlowLayout());
    final int BOTTOM = 0;
    final int LEFT = 100;
    final int RIGHT = 300;
    final int TOP = 0;
    EmptyBorder border1 = new EmptyBorder(TOP, LEFT, BOTTOM,RIGHT );

    JLabel firstLabel = new JLabel("FIRST");
    firstLabel.setBorder(border1);

    JLabel secondLabel = new JLabel("SECOND");

    displayPanel.add(firstLabel);
    displayPanel.add(secondLabel);
    setContentPane(displayPanel);

    pack();
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
}

public static void main(String[]args){
    new EmptyBorderShowCase();
}

}