import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;

@SuppressWarnings("serial")
public class MyToolView extends JPanel {

   public File[] file;
   public static int i = 0;

   final static JFileChooser fc = new JFileChooser();
   private static final int PREF_W = 900;
   private static final int PREF_H = 750;
   final DefaultListModel listModel = new DefaultListModel();
   final JList myList = new JList(listModel);
   private JLabel imageLabel = new JLabel();
   private javax.swing.JButton openButton;
   private JButton toTopBtn;
   private javax.swing.JList imageJList;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JPanel mainPanel;

   public MyToolView() {
      initComponents();
   }

   private void initComponents() {
      jScrollPane1 = new javax.swing.JScrollPane();
      imageJList = new javax.swing.JList(listModel);
      openButton = new javax.swing.JButton();
      toTopBtn = new JButton("To Top");

      JPanel topPanel = new JPanel();
      topPanel.add(jScrollPane1);
      topPanel.add(openButton);
      topPanel.add(toTopBtn);

      setLayout(new BorderLayout());
      add(topPanel, BorderLayout.PAGE_START);
      add(new JScrollPane(imageLabel), BorderLayout.CENTER);

      toTopBtn.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            toTopBtnActionPerformed(e);
         }
      });

      jScrollPane1.setFocusable(false);
      jScrollPane1.setName("jScrollPane1"); // NOI18N

      imageJList.setModel(new javax.swing.AbstractListModel() {
         String[] strings = { "AAAA.JPG", "BBBB.JPG" };

         public int getSize() {
            return strings.length;
         }

         public Object getElementAt(int i) {
            return strings[i];
         }
      });
      imageJList.setName("jList1"); // NOI18N
      imageJList.setCellRenderer(new JavaRenderer());
      jScrollPane1.setViewportView(imageJList);
      imageJList.addListSelectionListener(listSelectionListener);

      openButton.setFocusable(false);
      openButton.setName("openButton"); // NOI18N
      openButton.setAction(new OpenAction("Open"));

   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   private void toTopBtnActionPerformed(java.awt.event.ActionEvent evt) {

      // ******** here **********
      imageJList.removeListSelectionListener(listSelectionListener);
      int selectedIndex = imageJList.getSelectedIndex();
      if (selectedIndex < 0) {
         return;
      }
      String temp = (String) listModel.remove(selectedIndex);
      listModel.add(0, temp);

      // ******** here **********
      imageJList.addListSelectionListener(listSelectionListener);
   }

   ListSelectionListener listSelectionListener = new ListSelectionListener() {
      public void valueChanged(ListSelectionEvent listSelectionEvent) {
         System.out.print("First index: " + listSelectionEvent.getFirstIndex());
         System.out.print(", Last index: " + listSelectionEvent.getLastIndex());

         String path = (String) imageJList.getSelectedValue();
         System.out.println("path should be here: " + path);
         Image img;
         try {
            System.out.println("path is null: " + (path == null));
            File imageFile = new File(path);
            img = ImageIO.read(imageFile);
            imageLabel.setIcon(new ImageIcon(img));
            imageLabel.setText("");
         } catch (IOException ex) {
            ex.printStackTrace();
         }
      }
   };

   private class OpenAction extends AbstractAction {
      public OpenAction(String text) {
         super(text);
      }

      public void actionPerformed(ActionEvent evt) {

         fc.setMultiSelectionEnabled(true);
         int returnVal = fc.showDialog(null, "Open");
         int len = 0;

         if (returnVal == JFileChooser.APPROVE_OPTION) {
            imageJList.removeListSelectionListener(listSelectionListener); //!!
            file = fc.getSelectedFiles();
            len = file.length;
            System.out.println("length = " + len);

            // this code should be inside the if block
            for (i = 0; i < len; i++) {
               String path = file[i].getPath();
               System.out.printf("%d: %s%n", i, path);
               listModel.add(i, path);
            }
            imageJList.setModel(listModel);
            imageJList.addListSelectionListener(listSelectionListener); //!!
         }
         // imageJList.updateUI(); //!! you shouldn't call this.
      }
   }

   private static void createAndShowGui() {
     MyToolView mainPanel = new MyToolView();

      JFrame frame = new JFrame("MyToolView");
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

class JavaRenderer extends DefaultListCellRenderer {
   private int a;

   @Override
   public Component getListCellRendererComponent(JList jList1, Object value,
         int index, boolean isSelected, boolean hasFocus) {

      if (value instanceof String) {
         String name = (String) value;
         String[] splitedArray = null;
         splitedArray = name.split("\\\\");
         a = splitedArray.length - 1;
         name = splitedArray[a];
         System.out.println("name " + name);
         return super.getListCellRendererComponent(jList1, name, index,
               isSelected, hasFocus);// what we display
      } else {
         return super.getListCellRendererComponent(jList1, value, index,
               isSelected, hasFocus);// what we take
      }
   }
}