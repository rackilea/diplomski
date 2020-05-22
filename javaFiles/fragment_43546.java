import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Foo2 extends JPanel {
   DefaultComboBoxModel<Integer> jcPtIdModel = new DefaultComboBoxModel<>();
   JComboBox<Integer> jcPtIdCombo = new JComboBox<>(jcPtIdModel);

   public Foo2(List<Integer> ids) {
      if (ids != null) {
         updateIds(ids);
      }
      add(jcPtIdCombo);

      jcPtIdCombo.addItemListener(new MyItemListener());
   }

   public void updateIds(List<Integer> ids) {
      jcPtIdModel.removeAllElements();
      jcPtIdModel.addElement(null);
      for (Integer id : ids) {
         jcPtIdModel.addElement(id);
      }
   }

   private class MyItemListener implements ItemListener {
      @Override
      public void itemStateChanged(ItemEvent e) {
         //!! if (jcPatientIds.getSelectedItem().equals("")) {
         if (jcPtIdCombo.getSelectedItem() == null) {
            // Some stuff
         } else {
            // Here I am getting ClassCastException
            System.out.println((int) jcPtIdCombo.getSelectedItem());
            // Some other stuff
         }         
      }
   }

   private static void createAndShowGui() {
      ArrayList<Integer> items = new ArrayList<>();
      for (int i = 0; i < 10; i++) {
         items.add(i);
      }

      Foo2 mainPanel = new Foo2(items);

      JFrame frame = new JFrame("Foo2");
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