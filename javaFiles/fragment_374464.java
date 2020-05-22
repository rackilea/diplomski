import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

public class FooSwing extends JFrame {
   private static final int PREF_W = 600;
   private static final int PREF_H = 450;
   private JFileChooser fileChooser = new JFileChooser();
   private JTabbedPane tabbedPane = new JTabbedPane();

   public FooSwing() {
      JPanel btnPanel = new JPanel();
      btnPanel.add(new JButton(new AbstractAction("Open") {

         @Override
         public void actionPerformed(ActionEvent e) {
            btnOpenActionPerformed(e);
         }
      }));
      btnPanel.add(new JButton(new AbstractAction("Get Selected Text") {

         @Override
         public void actionPerformed(ActionEvent e) {
            FilePanel selectedComp = (FilePanel)tabbedPane.getSelectedComponent();
            if (selectedComp != null) {
               String text = selectedComp.getTextArea().getText();
               System.out.println(text);
            } else {
               System.out.println("No component selected");
            }
         }
      }));

      add(tabbedPane, BorderLayout.CENTER);
      add(btnPanel, BorderLayout.SOUTH);
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {

      int returnVal = fileChooser.showOpenDialog(this);

      if (returnVal == JFileChooser.APPROVE_OPTION) {
         File file = fileChooser.getSelectedFile();

         try {
            JPanel filePanel = new FilePanel(file);

            tabbedPane.add(filePanel, filePanel.getName());
            tabbedPane.setSelectedComponent(filePanel);
         } catch (IOException ex) {
            System.out.println("problem accessing file"
                  + file.getAbsolutePath());
         }
      } else {
         System.out.println("File access cancelled by user.");
      }
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShow();
         }
      });
   }

   private static void createAndShow() {
      FooSwing fooSwing = new FooSwing();
      fooSwing.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      fooSwing.pack();
      fooSwing.setLocationRelativeTo(null);
      fooSwing.setVisible(true);
   }
}

class FilePanel extends JPanel {

   private File file;
   private JTextArea textArea;
   private String name;

   public FilePanel(File file) throws FileNotFoundException, IOException {
      this.file = file;
      setLayout(new BorderLayout());

      textArea = new JTextArea();
      JScrollPane scroll = new JScrollPane(textArea);
      add(scroll, BorderLayout.CENTER);

      textArea.read(new FileReader(file.getAbsolutePath()), null);
      name = file.getName();
   }

   public File getFile() {
      return file;
   }

   public JTextArea getTextArea() {
      return textArea;
   }

   public String getName() {
      return name;
   }

}