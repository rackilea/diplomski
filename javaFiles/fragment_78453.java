import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

public class Foo {
   public static void main(String[] args) {
      A a = new A();
      B1 b1 = new B1();
      B2 b2 = new B2(a);

      JPanel panel = new JPanel(new GridLayout(0, 1));
      panel.add(a);
      panel.add(b1);
      panel.add(b2);

      JOptionPane.showMessageDialog(null, panel);
   }
}

class A extends JPanel {
   private JTextField textField = new JTextField(10);

   public A() {
      add(textField);
      textField.setEditable(false);
      textField.setFocusable(false);
      setBorder(BorderFactory.createTitledBorder("A"));
   }

   public void setText(String text) {
      textField.setText(text);
   }
}

class B1 extends JPanel {
   private JButton button = new JButton("Press ME -- this does nothing");

   public B1() {
      add(button);
      setBorder(BorderFactory.createTitledBorder("B1"));
      button.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent arg0) {
            A a = new A();
            a.setText("Hello from B1!");
         }
      });
   }
}

class B2 extends JPanel {
   private JButton button = new JButton("Press ME -- this works!!");
   private A a;

   public B2(final A a) {
      this.a = a;
      setBorder(BorderFactory.createTitledBorder("B2"));
      add(button);      
      button.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            a.setText("Hello from B2!");
         }
      });
   }
}