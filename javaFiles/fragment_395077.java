import java.awt.*;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

//!! import btn.button;

public class Test {

   private JFrame frame = new JFrame();
   private JTabbedPane tabpane = new JTabbedPane();
   private JPanel panel1 = new JPanel();
   private GridBagConstraints c = new GridBagConstraints();
   private final static boolean SHOULD_FILL = true;
   private GridBagLayout grid = new GridBagLayout();

   public Test() {

      frame.setVisible(true);
      frame.setSize(821, 421);

      final Toolkit toolkit = Toolkit.getDefaultToolkit();
      Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
      int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
      int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);

      frame.setLocation(x, y);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      JPanel container = new JPanel();
      container.setLayout(new BorderLayout());
      container.setBackground(new Color(0, 128, 0));

      tabpane = new JTabbedPane(); // Tab Pane
      tabpane.setBackground(new Color(0, 128, 0));
      tabpane.setSize(801, 351);

      JPanel jp1 = new JPanel(); // First Tab Panel
      jp1.setBackground(new Color(0, 128, 0));
      jp1.setLayout(grid);

      JButton popout = new JButton("MORE");
      popout.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            //!! HisTestButton button = new HisTestButton();

            new HisTestButton(Test.this); //!! passing in this
         }
      });
      jp1.add(popout);

      JPanel jp2 = new JPanel(); // Second Tab Panel
      jp2.setBackground(new Color(0, 128, 0));
      jp2.setLayout(grid);

      JPanel jp3 = new JPanel(); // Third Tab Panel
      jp3.setBackground(new Color(0, 128, 0));
      jp3.setLayout(grid);

      tabpane.addTab("Tab 1", jp1);
      // add selectedIndex here (1);
      tabpane.addTab("Tab 2", jp2);
      // add selectedIndex here (2);
      tabpane.addTab("Tab 3", jp3);
      // add selectedIndex here (3);

      frame.add(container);
      container.add(tabpane, BorderLayout.NORTH);

   }

   // !! public method that other classes can call to change tab
   public void openNextTab() {
      int selectedIndex = tabpane.getSelectedIndex();
      selectedIndex++;
      selectedIndex %= tabpane.getTabCount();
      tabpane.setSelectedIndex(selectedIndex);
   }

   //!! needed by JDialog
   public JFrame getFrame() {
      return frame;
   }

   public static void main(String[] args) {
      // Use the event dispatch thread for Swing components
      EventQueue.invokeLater(new Runnable() {
         @Override
         public void run() {
            new Test();
         }
      });

   }
}

class HisTestButton {
   protected static final int PREF_W = 200;
   protected static final int PREF_H = 200;
   JDialog dialog; // !! make this a JDialog
   GridBagLayout grid = new GridBagLayout();
   private Test test;  //!! add field

   //!! changed constructor parameter
   public HisTestButton(final Test test) {
      this.test = test; // !! set field

      // !! create our JDialog. Going to make it non-modal 
      dialog = new JDialog(test.getFrame(), "MyDialog", ModalityType.MODELESS);

      //!! frame2.setVisible(true);
      // !! frame2.setSize(200, 200); // never set visible til after components added

      JPanel jp = new JPanel() {
         @Override
         public Dimension getPreferredSize() {
            return new Dimension(PREF_W, PREF_H);
         }
      };
      jp.setBackground(new Color(0, 128, 0));
      jp.setLayout(grid);

      JButton btn = new JButton("SWITCH TO PANEL 2");
      btn.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            //!! 
            test.openNextTab();
         }
      });

      jp.add(btn);

      dialog.add(jp);

      // !! added
      dialog.pack();
      dialog.setVisible(true);
   }
}