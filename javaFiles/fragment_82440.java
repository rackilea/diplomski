import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Sample extends JFrame
{
    JTextField jTextField1, jTextField2;
    JButton jbtn;

Sample()
{       
    this.add(jTextField1=new JTextField(10));
    this.add(jTextField2=new JTextField(10));
    this.add(jbtn=new JButton("Convert"));

    jbtn.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent ae)
        {
            String text=jTextField1.getText().toLowerCase();
            String result="";
            char letter;
            for(int i=0;i<text.length();i++)
            {
                letter=text.charAt(i);
                if(Character.isLetter(letter))
                    result+=Integer.toString(letter-'a'+1);
            }       
            jTextField2.setText(result);
            System.out.println("Final Output is: "+result);
        }
    });
}
 public static void main(String a[])
 {
    JFrame jf = new Sample();
    jf.setLayout(new FlowLayout());
    jf.setSize(400, 400);
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jf.setVisible(true);
 }
}