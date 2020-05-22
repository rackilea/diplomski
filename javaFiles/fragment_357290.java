import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


@SuppressWarnings("serial")
public class ClusterEndusersGui2 extends JPanel {
   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            ClusterEndusersGui2 mainPanel = new ClusterEndusersGui2();
            JFrame gui = new JFrame("GUI");
            gui.add(mainPanel);
            gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gui.pack();
            gui.setLocationRelativeTo(null);
            gui.setVisible(true);
         }
      });
   }

   public ClusterEndusersGui2() {
      initComponents();
   }

   private void initComponents() {
      someButton = new JButton("Selected Tabbed Pane");
      tabbedPaneClusters = new JTabbedPane();
      for (String s : Variables2.focusedHostnames) {
         ClusterTab2 cluster = new ClusterTab2(s);
         tabbedPaneClusters.addTab(s, cluster);
      }

      add(tabbedPaneClusters);
      add(someButton);

      someButton.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            ClusterTab2 tabbedPane = (ClusterTab2) tabbedPaneClusters.getSelectedComponent();
            if (tabbedPane != null) {
               System.out.println("Selected Tab: " + tabbedPane.getName());
            }
         }
      });
   }

   public void printTabNames() {
      System.out.println("Tab Name: " + tabbedPaneClusters.getTitleAt(0));
   }

   private JTabbedPane tabbedPaneClusters;
   private JButton someButton;
}

@SuppressWarnings("serial")
class ClusterTab2 extends JPanel {
   private DefaultListModel<String> listItems;

   public ClusterTab2(String name) {
      setName(name);
      initComponents();
   }

   public void getUsers(ActionEvent e) {
      //!! ClusterEndusersGui2.printTabNames();
   }

   private void initComponents() {
      final JScrollPane listScrollPane;
      final JList<String> list1;
      final JButton btnRemoveAll;
      final JButton btnAddAll;
      final JButton btnRemoveFromAll;
      listScrollPane = new JScrollPane();
      list1 = new JList<>();
      list1.setPrototypeCellValue("                            ");
      btnRemoveAll = new JButton();
      btnAddAll = new JButton();
      btnRemoveFromAll = new JButton();
      listItems = new DefaultListModel<>();
      listItems.addElement("Test");
      list1.setModel(listItems);
      listScrollPane.setViewportView(list1);

      // ---- btnRemoveAll ----
      btnRemoveAll.setText("Remove all from Cluster");
      btnAddAll.setText("Add all to Cluster");
      btnAddAll.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            getUsers(e);
         }
      });
      btnRemoveFromAll.setText("Remove from All Clusters");

      JPanel btnPanel = new JPanel(new GridLayout(0, 1, 4, 4));
      btnPanel.add(btnRemoveAll);
      btnPanel.add(btnAddAll);
      btnPanel.add(btnRemoveFromAll);

      btnRemoveAll.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            listItems.removeAllElements();
         }
      });
      btnAddAll.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            listItems.addElement("Fubar!");
         }
      });

      JPanel btnWrapPanel = new JPanel(new GridBagLayout());
      btnWrapPanel.add(btnPanel);

      add(listScrollPane);
      add(btnWrapPanel);
   }
}

class Variables2 {
   public static String[] focusedHostnames = { 
      "1", "2", "3", "4", "5", "6", "7" 
   };
}