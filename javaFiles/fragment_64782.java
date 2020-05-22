import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class LabelDotTest
{
  private String fullText = "";
  private String clippedText = "";

  public LabelDotTest()
  {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(new Dimension(280, 50));
    frame.setLocationRelativeTo(null);

    String[] testNames = new String[]{"John", "Mary", "Peter", "Hank", "Alys", "Debbie"};
    int DISPLAY_MAX = 4;

    for(int i=0; i<testNames.length; i++)
    {
      fullText += testNames[i];
      if (i<DISPLAY_MAX)
         clippedText += testNames[i];

      if (i<testNames.length-1)
      {
        fullText += ", ";
        if (i<DISPLAY_MAX)
          clippedText += ", ";
      }
    }

    final JLabel label = new JLabel(clippedText);
    label.setToolTipText(fullText);

    final JButton button = new JButton("...");
    button.setBorder(BorderFactory.createEmptyBorder());
    button.setOpaque(false);
    button.setBackground(new Color(0,0,0,0));
    button.setToolTipText(fullText);
    button.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e)
        {
          label.setText(fullText);
          button.getParent().remove(button);
        }
      });

    JPanel panel = new JPanel(new GridBagLayout());
    panel.add(label);
    panel.add(button);
    frame.add(panel);

    frame.setVisible(true);
  }

  public static void main(String[] args)
  {
    new LabelDotTest();
  }
}