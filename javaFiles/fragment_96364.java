import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

@SuppressWarnings("serial")
public class CardExample extends JPanel {
   enum MyColor {
      RED("Red", Color.RED), YELLOW("Yellow", Color.YELLOW), BLUE("Blue",
            Color.BLUE);
      private String name;
      private Color color;

      private MyColor(String name, Color color) {
         this.name = name;
         this.color = color;
      }

      public String getName() {
         return name;
      }

      public Color getColor() {
         return color;
      }
   }

   private static final int GAP = 3;

   private CardLayout cardlayout = new CardLayout();
   private JPanel cardHolderPanel = new JPanel(cardlayout);

   public CardExample() {
      JPanel btnPanel = new JPanel(new GridLayout(1, 0, GAP, GAP));
      for (MyColor myColor : MyColor.values()) {
         JPanel cardPanel = new JPanel();
         cardPanel.setPreferredSize(new Dimension(200, 200));
         cardPanel.setBackground(myColor.getColor());
         cardHolderPanel.add(cardPanel, myColor.getName());

         btnPanel.add(new JButton(new ButtonAction(myColor)));
      }

      setLayout(new BorderLayout(GAP, GAP));
      setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
      add(cardHolderPanel, BorderLayout.CENTER);
      add(btnPanel, BorderLayout.SOUTH);
   }

   private class ButtonAction extends AbstractAction {
      private MyColor myColor;

      public ButtonAction(MyColor myColor) {
         super(myColor.getName());
         this.myColor = myColor;
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         cardlayout.show(cardHolderPanel, myColor.getName());
      }
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("CardExample");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new CardExample());
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}