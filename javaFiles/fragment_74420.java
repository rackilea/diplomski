import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PopupExample implements ActionListener
{
    JFrame frame;
    JTextField t1;
    JButton btn;
    public PopupExample()
    {
       frame=new JFrame();
       frame.setLayout(null);
       frame.setSize(700,700);
       frame. setLocation(300,10);

       t1=new JTextField();
       t1.setBounds(82,10,100,20);

       frame.add(t1);

       btn=new JButton("SUBMIT");
       btn.setBounds(200,10,100,20);
        btn.addActionListener(this);
       frame.add(btn);
       frame.setVisible(true);
     }

     public static void main(String ar[])
     {
        PopupExample obj=new PopupExample();
     }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn)
        {
            String input=t1.getText();
            if(input.equals("dog"))
            {
                JOptionPane.showMessageDialog(null,"my dog");
                //you can popup new frame here about dog
                //create the object of new class (which contain dog details)here.
                //you can use show()
            }
        }
    }
}