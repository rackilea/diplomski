import java.awt.BorderLayout;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Lab52 
{

public static void main(String[] args) 
{
    JFrame frame = new JFrame();

    Panel nPanel = new Panel();
    frame.add(nPanel, BorderLayout.NORTH);
    Panel sPanel = new Panel();
    frame.add(sPanel, BorderLayout.SOUTH);

    JTextField[] tf = new JTextField[10];
    for(int k = 0; k < tf.length; k++)
    {
        tf[k] = new JTextField(4);
        nPanel.add(tf[k]);
    }
    RandListener listen = new RandListener(tf);

    JButton bRand = new JButton("Randomize");
    bRand.setActionCommand("bRand");
    bRand.addActionListener(listen);
    sPanel.add(bRand);

    JButton bMaxMin = new JButton("Max, Min");
    bMaxMin.setActionCommand("bMaxMin"); // These 2 lines were refering to bRand, not to bMaxMin
    bMaxMin.addActionListener(listen); 
    sPanel.add(bMaxMin);

    frame.pack();
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}    
}