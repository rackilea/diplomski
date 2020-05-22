/*
This java program copies the value from a jTextField, adds it to a     predifined value 
and send it to command-line as a parameter. All these happens if you click     the jButton
*/


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cmdJavaTest extends JFrame {
JTextField jTextField1 = new JTextField(20);
JButton jButton1 = new JButton("Click");
JLabel jLabel1 = new JLabel();

public cmdJavaTest() {
    super("CmdJavaParameterPass");

    getContentPane().setLayout(new FlowLayout());

    getContentPane().add(jTextField1);
    getContentPane().add(jButton1);
    getContentPane().add(jLabel1);
    jButton1.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            sendParam();
        }
        });
        setSize(300, 170);
        setVisible(true);
    }

  public void sendParam(){
      try{
            String val = "Computer"+jTextField1.getText(); //Put whatever you want to pass as a prefix in place of "Computer"
            jLabel1.setText(val);
            Process p ;
            p = Runtime.getRuntime().exec("cmd /c start c:\\batFile.bat "+val+"");
        }
        catch(Exception e){
            e.printStackTrace();
        }
  }

  public static void main(String argv[]) {
    new cmdJavaTest();
  }
}