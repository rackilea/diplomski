import java.awt.*;
import java.awt.event.ActionEvent;   
import javax.swing.*;

@SuppressWarnings("serial")
public class CreatePanelsTest2 {
   protected static final int PREF_W = 600;
   protected static final int PREF_H = 450;
   JPanel mainPanel = new JPanel() {
      @Override
      public Dimension getPreferredSize() {
         return new Dimension(PREF_W, PREF_H);
      }
   };
   JPanel panelHolderPanel = new JPanel(new GridLayout(1, 0));

   public CreatePanelsTest2() {
      JPanel btnPanel = new JPanel(new GridLayout(1, 0, 5, 0));
      btnPanel.add(new JButton(new AddAction()));
      btnPanel.add(new JButton(new RemoveAction()));

      JPanel borderLayoutPanel = new JPanel(new BorderLayout());
      borderLayoutPanel.add(panelHolderPanel, BorderLayout.WEST);
      JScrollPane scrollPane = new JScrollPane(borderLayoutPanel);
      scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

      mainPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
      mainPanel.setLayout(new BorderLayout());
      mainPanel.add(scrollPane, BorderLayout.CENTER);
      mainPanel.add(btnPanel, BorderLayout.SOUTH);
   }

   public JComponent getMainComponent() {
      return mainPanel;
   }

   private class AddAction extends AbstractAction {
      int counter = 0;
      public AddAction() {
         super("Add");
      }

      @Override
      public void actionPerformed(ActionEvent evt) {
         counter++;
         JPanel innerPanel = new JPanel(new GridLayout(0, 1));
         innerPanel.add(new JButton("Foo " + counter));
         innerPanel.add(new JButton("Bar " + counter));

         panelHolderPanel.add(innerPanel);
         mainPanel.revalidate();
         mainPanel.repaint();
      }
   }

   private class RemoveAction extends AbstractAction {
      public RemoveAction() {
         super("Remove");
      }

      @Override
      public void actionPerformed(ActionEvent arg0) {
         Component[] comps = panelHolderPanel.getComponents();
         if (comps.length > 0) {
            panelHolderPanel.remove(comps[comps.length - 1]);
            mainPanel.revalidate();
            mainPanel.repaint();
         }
      }
   }

   private static void createAndShowGui() {
      CreatePanelsTest2 test2 = new CreatePanelsTest2();
      JFrame frame = new JFrame("CreatePanelsTest2");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(test2.getMainComponent());
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