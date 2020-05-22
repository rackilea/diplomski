import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.text.ParseException;

public class HangmanGUI {
   private DetailsPanel myPanel;
   private ImagePanel imagePanel = new ImagePanel();

   public HangmanGUI() throws ParseException {
      myPanel = new DetailsPanel();
      JFrame myframe = new JFrame();
      // myframe.getContentPane().setLayout(new BorderLayout());
      myframe.getContentPane().add(imagePanel, BorderLayout.CENTER);
      myframe.getContentPane().add(myPanel, BorderLayout.SOUTH);
      myframe.setTitle("Hangman Game");
      // myframe.setVisible(true);
      // myframe.setLocationRelativeTo(null);
      myframe.pack();
      myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      myframe.setLocationRelativeTo(null);
      myframe.setVisible(true);
   }

   public static void main(String[] args) throws ParseException {
      new HangmanGUI();
   }
}

class ImagePanel extends JPanel {
   private static final int PREF_W = 400;
   private static final int PREF_H = PREF_W;
   private static final String TITLE = "Hangman Image";

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   public ImagePanel() {
      setBorder(BorderFactory.createTitledBorder(TITLE));
   }
}

class DetailsPanel extends JPanel {
   public DetailsPanel() {
      setLayout(new BorderLayout());

      setBorder(BorderFactory.createTitledBorder(" ciick here "));
      add(createFormattedPanel(), BorderLayout.PAGE_START);

      JPanel letterPanel = new JPanel(new GridLayout(0, 5));
      for (char alphabet = 'A'; alphabet <= 'Z'; alphabet++) {
         String buttonText = String.valueOf(alphabet);
         JButton letterButton = new JButton(buttonText);
         letterButton.addActionListener(clickedbutton());
         letterPanel.add(letterButton, BorderLayout.CENTER);
      }
      add(letterPanel, BorderLayout.CENTER);
   }

   private ActionListener clickedbutton() {
      return new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            String actionCommand = e.getActionCommand();
            System.out.println("actionCommand is: " + actionCommand);
         }
      };
   }

   public JPanel createFormattedPanel() {
      JPanel panel = new JPanel();
      MaskFormatter formatter = null;
      try {
         JLabel label = new JLabel("Guesss");
         formatter = new MaskFormatter("? ? ? ? ? ? ?");
         formatter.setPlaceholderCharacter('?');
         JFormattedTextField input = new JFormattedTextField(formatter);
         input.setColumns(20);
//         this.add(label);
//         this.add(input);
         panel.add(label);
         panel.add(input);
      } catch (java.text.ParseException exc) {
         System.err.println("formatter is bad: " + exc.getMessage());
         System.exit(-1);
      }

      return panel;
   }
}