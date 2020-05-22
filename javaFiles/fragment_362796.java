import java.awt.event.*;
import java.beans.PropertyVetoException;
import javax.swing.*;

public class Mcve1 {
   private static void createAndShowGui() {
      LibrarayLMS.main(null);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}

class Addbook {
   static JInternalFrame frame = new JInternalFrame("Add Book");

   public void addframe() {
      JPanel panel = new JPanel();

      // ****** comment and un-comment the line below
      // frame = new JInternalFrame("Add Book");

      frame.setSize(700, 568);
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.add(panel);
      frame.setResizable(false);
      JButton btn_add = new JButton("ADD");
      panel.add(btn_add);
      btn_add.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent ev) {
            frame.dispose();
         }
      });
      JButton exit = new JButton("exit");
      panel.add(exit);
      exit.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            frame.dispose();
         }
      });
      frame.setVisible(true);
   }
}

class LibrarayLMS {

   JDesktopPane desktop;
   JFrame f = new JFrame("A.M Library");

   public void framelaunch() {
      JMenuBar mb = new JMenuBar();
      JMenu books = new JMenu("Book's");
      mb.add(books);
      JMenuItem adbook = new JMenuItem("Add Books");
      books.add(adbook);
      adbook.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            Addbook objadd = new Addbook();
            objadd.addframe();
            objadd.frame.setVisible(true);
            desktop.add(objadd.frame); // !! ***** here *****
            try {
               objadd.frame.setSelected(true);
            } catch (PropertyVetoException exn) {
               exn.printStackTrace();
            }

         }
      });

      desktop = new JDesktopPane();
      desktop.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
      f.getContentPane().add(desktop);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setVisible(true);
      f.setJMenuBar(mb);
      f.setSize(1000, 625);
      f.setResizable(false);
      f.setContentPane(desktop);
   }

   public static void main(String[] args) {
      LibrarayLMS myframe = new LibrarayLMS();
      myframe.framelaunch();
   }

}