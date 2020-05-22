import java.awt.Component;
import java.awt.event.*;
import javax.swing.*;

public class MyComboEg extends JPanel {
   private static final MyData[] data = {
         new MyData("Monday", 1, false),
         new MyData("Tuesday", 2, false),
         new MyData("Wednesday", 3, false),
         new MyData("Thursday", 4, false),
         new MyData("Friday", 5, false),
         new MyData("Saturday", 6, true),
         new MyData("Sunday", 7, true),
   };   
   private JComboBox<MyData> myCombo = new JComboBox<MyData>(data);
   private JTextField textField = new JTextField(10);
   private JTextField valueField = new JTextField(10);
   private JTextField weekendField = new JTextField(10);

   public MyComboEg() {
      add(myCombo);
      add(new JLabel("text:"));
      add(textField);
      add(new JLabel("value:"));
      add(valueField);
      add(new JLabel("weekend:"));
      add(weekendField);

      myCombo.setRenderer(new DefaultListCellRenderer(){
         @Override
         public Component getListCellRendererComponent(JList list,
               Object value, int index, boolean isSelected, boolean cellHasFocus) {
            String text = value == null ? "" : ((MyData)value).getText();
            return super.getListCellRendererComponent(list, text, index, isSelected,
                  cellHasFocus);
         }
      });
      myCombo.setSelectedIndex(-1);

      myCombo.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent arg0) {
            // MyData myData = (MyData) myCombo.getSelectedItem();
            MyData myData = myCombo.getSelectedItem();
            textField.setText(myData.getText());
            valueField.setText(String.valueOf(myData.getValue()));
            weekendField.setText(String.valueOf(myData.isWeekend()));
         }
      });
   }

   private static void createAndShowGui() {
      MyComboEg mainPanel = new MyComboEg();

      JFrame frame = new JFrame("MyComboEg");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

class MyData {
   private String text;
   private int value;
   private boolean weekend;

   MyData(String text, int value, boolean weekend) {
      this.text = text;
      this.value = value;
      this.weekend = weekend;
   }
   public String getText() {
      return text;
   }
   public int getValue() {
      return value;
   }
   public boolean isWeekend() {
      return weekend;
   }


}