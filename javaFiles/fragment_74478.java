import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import java.awt.*;

public class TestEJCBX extends JFrame {
   JComboBox<String> jcbx = new JComboBox<>();

   public TestEJCBX() {
      super("Editable JComboBox");
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      jcbx.setEditable(true);

      getContentPane().setLayout(new FlowLayout());
      getContentPane().add(jcbx);

      JTextField editorComponent = (JTextField) jcbx.getEditor()
            .getEditorComponent();

      Document doc = editorComponent.getDocument();
      doc.addDocumentListener(new DocumentListener() {

         @Override
         public void removeUpdate(DocumentEvent e) {
            System.out.println("text changed");
         }

         @Override
         public void insertUpdate(DocumentEvent e) {
            System.out.println("text changed");
         }

         @Override
         public void changedUpdate(DocumentEvent e) {
            System.out.println("text changed");
         }
      });

      pack();
      setLocationRelativeTo(null);
      setVisible(true);
   }

   public static void main(String argv[]) {
      new TestEJCBX();
   }
}