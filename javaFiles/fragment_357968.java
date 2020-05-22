import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

public class Example {

    public static void main(String ... s){
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextField field1 = new JTextField(5);

        final JTextField field2 = new JTextField(5);

        field1.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void removeUpdate(DocumentEvent e) {
                validate(e);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                validate(e);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validate(e);
            }

            private void validate(DocumentEvent e) {
                try {
                    String text = e.getDocument().getText(0, e.getDocument().getLength());
                    if(text.equals("Jhon")){
                        field2.setText("Men");
                    } else {
                        field2.setText("");
                    }
                } catch (BadLocationException e1) {
                    e1.printStackTrace();
                }
            }
        });
        f.add(field1,BorderLayout.WEST);
        f.add(field2,BorderLayout.EAST);
        f.pack();
        f.setVisible(true);
    }
}