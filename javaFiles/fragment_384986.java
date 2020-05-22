import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class TestFoo2 {

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndDisplayGui();
         }
      });
   }

   public static void createAndDisplayGui() {
      final JFrame frame = new JFrame("Foo");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      JButton button = new JButton(new AbstractAction("Press Me") {

         @Override
         public void actionPerformed(ActionEvent evt) {
            TouchOn2 touchOn2 = new TouchOn2(frame);
            touchOn2.setVisible(true);
         }
      });

      JPanel panel = new JPanel();
      panel.add(button);
      frame.add(panel);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }
}

@SuppressWarnings("serial")
class TouchOn2 extends JDialog {
   private JPanel mainPanel;

   @SuppressWarnings({ "rawtypes", "unused" })
   public ArrayList Reader(String Txtfile) {
      ArrayList<String> list = new ArrayList<>();
      for (int i = 0; i < 100; i++) {
         list.add("Data String Number " + (i + 1));
      }

      // return toString();
      // !! return null;
      return list;
   }

   public TouchOn2(Window owner) {
      super(owner);
      setPanels();

      setModalityType(ModalityType.APPLICATION_MODAL);
      setSize(400, 300);
      setVisible(true);
   }

   @SuppressWarnings("unchecked")
   public void setPanels() {
      mainPanel = new JPanel(new GridLayout(0, 2));
      JPanel containerPanel = new JPanel(new GridLayout(0, 1));
      JLabel startDay = new JLabel("Day:");
      final JTextField sDay = new JTextField();

      JLabel startMonth = new JLabel("Month:");
      final JTextField sMonth = new JTextField();

      JLabel startYear = new JLabel("Year:");
      final JTextField sYear = new JTextField("2015");
      final String trainline = "";

      JLabel touchOnTimehr = new JLabel("Time Hour: ");
      JLabel touchOnTimem = new JLabel("Time Minute:");
      JLabel station = new JLabel("Station: ");

      final JTextField touchOnTimeFieldhour = new JTextField();
      final JTextField touchOnTimeFieldminute = new JTextField();

      JPanel lowerPanel = new JPanel(new FlowLayout());
      ArrayList<String> stations = Reader("TrainLines.txt");
      final JComboBox<String> cb = new JComboBox<>(
            stations.toArray(new String[stations.size()]));
      final JRadioButton belgrave = new JRadioButton("Belgrave Line");
      belgrave.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {

         }
      });
      final JRadioButton glenwaverly = new JRadioButton("Glen Waverly Line");
      glenwaverly.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {

         }
      });
      ButtonGroup bG = new ButtonGroup();
      JButton apply = new JButton("Touch on");
      JButton cancel = new JButton("Cancel");
      cancel.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            dispose();
         }
      });
      apply.addActionListener(new ActionListener() {
         @SuppressWarnings("unused")
         public void actionPerformed(ActionEvent e) {

            String timestamp = new java.text.SimpleDateFormat("dd/MM/yyyy")
                  .format(new Date());
            String day = sDay.getText();
            String month = sMonth.getText();
            String year = sYear.getText();
            String hour = touchOnTimeFieldhour.getText();
            String minute = touchOnTimeFieldminute.getText();
            if (belgrave.isSelected()) {
               // !! ***** note you're shadowing variables here!!!! ****
               String trainline = belgrave.getText();
            }
            if (glenwaverly.isSelected()) {
               // !! and here too
               String trainline = glenwaverly.getText();
            }
            System.out.println(trainline);
         }
      });

      cb.setVisible(true);
      bG.add(belgrave);
      bG.add(glenwaverly);
      mainPanel.add(startDay);
      mainPanel.add(sDay);
      mainPanel.add(startMonth);
      mainPanel.add(sMonth);
      mainPanel.add(startYear);
      mainPanel.add(sYear);
      mainPanel.add(touchOnTimehr);
      mainPanel.add(touchOnTimeFieldhour);
      mainPanel.add(touchOnTimem);
      mainPanel.add(touchOnTimeFieldminute);
      mainPanel.add(belgrave);
      mainPanel.add(glenwaverly);
      mainPanel.add(station);
      mainPanel.add(new JLabel());
      mainPanel.add(cb);
      lowerPanel.add(apply);
      lowerPanel.add(cancel);
      touchOnTimeFieldhour.setSize(10, 10);
      containerPanel.add(mainPanel);
      containerPanel.add(lowerPanel);

      add(containerPanel);
   }

}