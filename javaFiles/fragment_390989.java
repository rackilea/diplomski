import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
class SimpleGui implements ActionListener 
{
JButton button;
SimpleGui g;
JTextArea textarea;
JFrame frame;
String data;
public static void main (String[] args) 
{
    SimpleGui g = new SimpleGui();
    g.go();
}
public void go()
{
    frame = new JFrame();
    button = new JButton("Insert Player");
    textarea = new JTextArea("Paste data here!");
    frame.setLayout(new BorderLayout());
    frame.getContentPane().add(button, BorderLayout.SOUTH);
    button.addActionListener(this);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 300);
    frame.setVisible(true);
}
@Override
public void actionPerformed(ActionEvent e) 
{
    if(e.getActionCommand().equals("Insert Player"))
    {
        button.setText("Now paste the data!");
        frame.getContentPane().add(textarea, BorderLayout.CENTER);
    }
    else if(e.getActionCommand().equals("Now paste the data!"))
    {
        data = textarea.getText();
        System.out.println(data);
    }
}
}