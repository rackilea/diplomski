import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class Test {

   public static void main(String[] args) {
      final Person person = new Person();
      final SibListModel listModel = new SibListModel(person);

      SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            try {
               JFrame frame = new JFrame();
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               JPanel panel = new JPanel();
               frame.setContentPane(panel);

               JList<String> list = new JList<String>(listModel);
               panel.add(new JScrollPane(list));
               frame.pack();
               frame.setLocationRelativeTo(null);
               frame.setVisible(true);

               // person.addSibling("Bob");
               listModel.addSibling("Bob");
            } catch (Throwable ex) {
               ex.printStackTrace();
            }
         }
      });

   }

   private static class SibListModel extends AbstractListModel<String> {
      private Person person;

      public SibListModel(Person person) {
         this.person = person;
      }

      @Override
      public String getElementAt(int index) {
         return person.getSibling(index);
      }

      @Override
      public int getSize() {
         return person.getNumSiblings();
      }

      public void addSibling(String sib) {
         person.addSibling(sib);
         fireIntervalAdded(this, person.getNumSiblings() - 1, person.getNumSiblings());
      }
   }

   private static class Person {

      List<String> siblings = new ArrayList<String>();

      public Person() {
         siblings.add("Janice");
      }

      public void addSibling(String sibling) {
         siblings.add(sibling);
      }

      public String getSibling(int index) {
         return siblings.get(index);
      }

      public int getNumSiblings() {
         return siblings.size();
      }

   }

}