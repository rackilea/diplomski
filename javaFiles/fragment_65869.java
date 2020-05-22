import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class S4 extends JFrame implements ItemListener {

    JCheckBox c1, c2;
    JTextField t1;

    public S4() {
         setSize(300,150);
         setVisible(true);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         Panel p1 = new Panel();
         c1 = new JCheckBox("Bold",false);
         c2 = new JCheckBox("Italic",false);
         t1 = new JTextField(40);
         p1.add(t1);
         p1.add(c1);
         p1.add(c2);        
         c1.addItemListener(this);
         c1.addItemListener(this);
         getContentPane().add(p1);
    }

    public void itemStateChanged(ItemEvent e){
         Font f;        
         if(c1.isSelected() && c2.isSelected()){
             f = new Font("Arial",Font.BOLD+Font.ITALIC,13);
         }
         else if (c1.isSelected()){
             f = new Font("Arial",Font.BOLD,13);
         }
         else if (c2.isSelected()){
             f = new Font("Arial",Font.ITALIC,13);
         }
         else {
             f = new Font("Arial",Font.PLAIN,13);
         }

         t1.setFont(f);
    } 

    public static void main(String [] args){
         new S4();
    }
}