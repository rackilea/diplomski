import java.awt.event.ActionEvent;
import javax.swing.*;

public class TestList {

   private static void createAndShowGui() {
      String[] data = {"Mon", "Tues", "Wed", "Thurs", "Fri", "Sat", "Sun"};
      final DefaultListModel<String> model = new DefaultListModel<String>();
      for (String datum : data) {
         model.addElement(datum);
      }
      final JList<String> myList = new JList<String>(model);      
      JButton toTop = new JButton(new AbstractAction("To Top") {

         @Override
         public void actionPerformed(ActionEvent arg0) {
            int selectedIndex = myList.getSelectedIndex();
            if (selectedIndex < 0) {
               return;
            }
            String temp = model.remove(selectedIndex);
            model.add(0, temp);
         }
      });



      JPanel mainPanel = new JPanel();
      mainPanel.add(new JScrollPane(myList));
      mainPanel.add(toTop);


      JFrame frame = new JFrame("TestList");
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