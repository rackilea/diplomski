import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.*;
import javax.swing.text.JTextComponent;

public class TestFieldVerification {
   public static final Color ERROR_COLOR = new Color(254,157,157);
   private static final int COLS = 8;
   private JPanel mainPanel = new JPanel();
   private JTextField verifiedField = new JTextField(COLS);
   private JTextField focusCheckedField = new JTextField(COLS);
   private Color defaultBackground = null;

   public TestFieldVerification() {
      verifiedField.setInputVerifier(new MyVerfier(this));
      focusCheckedField.addFocusListener(new MyFocusCheck(this));

      mainPanel.add(new JLabel("With InputVerfier:"));
      mainPanel.add(verifiedField);
      mainPanel.add(new JLabel("With FocusListener:"));
      mainPanel.add(focusCheckedField);
   }

   public boolean verifyText(String text) {
      try {
         Integer.parseInt(text);
         return true;
      } catch (NumberFormatException nfe) {
         return false;
      }
   }

   public void setFieldBackground(JComponent component, boolean verified) {
      if (defaultBackground == null) {
         defaultBackground = component.getBackground();
      }
      Color bg = verified ? defaultBackground : ERROR_COLOR;
      component.setBackground(bg);
   }

   public JComponent getMainPanel() {
      return mainPanel;
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("MyVerifier");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new TestFieldVerification().getMainPanel());
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

class MyVerfier extends InputVerifier {
   private TestFieldVerification gui;

   public MyVerfier(TestFieldVerification gui) {
      this.gui = gui;
   }

   @Override
   public boolean shouldYieldFocus(JComponent input) {
      gui.setFieldBackground(input, super.shouldYieldFocus(input));
      return super.shouldYieldFocus(input);
   }

   @Override
   public boolean verify(JComponent input) {
      String text = ((JTextComponent) input).getText();
      return gui.verifyText(text);
   }

}

class MyFocusCheck extends FocusAdapter {
   private TestFieldVerification gui;

   public MyFocusCheck(TestFieldVerification gui) {
      this.gui = gui;
   }

   @Override
   public void focusLost(FocusEvent e) {
      JTextComponent textComp = (JTextComponent) e.getSource();
      String text = textComp.getText();
      boolean verified = gui.verifyText(text);
      gui.setFieldBackground(textComp, verified);
      if (!verified) {
         textComp.requestFocusInWindow();
      }
   }
}