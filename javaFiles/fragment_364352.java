import java.awt.event.ActionEvent;
import javax.swing.*;

public class Test2 extends JPanel implements Fooable {
   private JTextField field = new JTextField(10);
   private JTextArea textarea = new JTextArea(20, 30);
   private JButton button = new JButton();

   public Test2() {
      textarea.setFocusable(false);
      JScrollPane scrollPane = new JScrollPane(textarea);
      scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

      add(field);
      add(scrollPane);

      add(button);
   }

   public void setActions(Action action) {
      button.setAction(action);
      field.setAction(action);
   }

   @Override
   public String getFieldText() {
      field.selectAll();
      return field.getText();
   }

   @Override
   public void appendText(String text) {
      textarea.append(text + "\n");
   }


   private static void createAndShowGui() {
      Test2 mainPanel = new Test2();
      Action myAction = new MyAction("Press Me", KeyEvent.VK_P, mainPanel);
      mainPanel.setActions(myAction);

      JFrame frame = new JFrame("Test2");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
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

interface Fooable {
   String getFieldText();
   void appendText(String text);
}

class MyAction extends AbstractAction {
   private Fooable fooable;

   public MyAction(String name, int mnemonic, Fooable fooable) {
      super(name);
      putValue(MNEMONIC_KEY, mnemonic);
      this.fooable = fooable;
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      if (fooable != null) {
         fooable.appendText(fooable.getFieldText());
      }
   }
}