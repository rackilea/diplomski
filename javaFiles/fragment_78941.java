import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;

public class Frame2{
  JFrame frame;

  Frame2()
  {
    frame=new JFrame("Tetris");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500, 600);

    // *** Commented this line
    //frame.setLayout(null);

    frame.setResizable(false);
    ImageIcon img = new ImageIcon("Blocks.png");
    frame.setIconImage(img.getImage());
    frame.getContentPane().setBackground(Color.blue);

    // *** Added this JLabel
    JLabel label = new JLabel("Sample text");
    label.setFont(label.getFont().deriveFont(20.0F));
    label.setForeground(Color.white);
    frame.getContentPane().add(label, BorderLayout.CENTER);

    // This line is moved down
    frame.setVisible(true);

    JOptionPane.showMessageDialog(null, "        Press Ok To Start","Start", JOptionPane.INFORMATION_MESSAGE);    
  }

  public static void main(String[] args)
  {
    new Frame2();
  }
}