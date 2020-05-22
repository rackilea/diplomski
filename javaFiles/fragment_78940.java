import java.awt.Graphics;
import java.awt.Color;
import javax.swing.*;
import javax.swing.JPanel;

public class Frame{
  JFrame frame;

  Frame()
  {
    frame=new JFrame("Tetris");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500, 600);
    frame.setLayout(null);
    frame.setResizable(false);
    ImageIcon img = new ImageIcon("Blocks.png");
    frame.setIconImage(img.getImage());
    //frame.getContentPane().setBackground(Color.blue);
    frame.setContentPane(new MainPanel());

    // This line is moved down
    frame.setVisible(true);

    JOptionPane.showMessageDialog(null, "        Press Ok To Start","Start", JOptionPane.INFORMATION_MESSAGE);   
  }

  public static void main(String[] args)
  {
    new Frame();
  }
}

class MainPanel extends JPanel
{
  MainPanel()
  {
    setOpaque(true);
    setBackground(Color.blue);
  }

  @Override
  protected void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    g.setFont(g.getFont().deriveFont(20.0F));
    g.setColor(Color.white);
    g.drawString("Sample text", 50, 50);
  }
}