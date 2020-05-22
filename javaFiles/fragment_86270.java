import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.event.*;

class TestFrameExample extends JFrame  implements ActionListener{
    static JLabel label ; 
    public static TestFrameExample test;
    TestFrameExample()
   {
      JPanel panel = new JPanel();
      panel.setLayout(new FlowLayout());
      label = new JLabel("This is a label!");
      JButton button = new JButton("Open");
      button.setText("Press me");
      button.addActionListener(this);
      panel.add(label);
      panel.add(button);
      add(panel);
      setSize(300, 300);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
  }

   public void actionPerformed(ActionEvent a)
   {
          new TestFrameExample1();
  }
  public static void main(String s[]) {
      test=new TestFrameExample();
  }
}

class TestFrameExample1 extends JFrame  implements ActionListener {
  JTextField t;
  TestFrameExample test;
  public TestFrameExample1()
  {
        setSize(300, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        t=new JTextField();
        t.setBounds(100,20,150,20);
        JButton button=new JButton("oK");
        button.setBounds(100,50,100,30);
        button.addActionListener(this);
        add(t);
        add(button);
    }
    public void actionPerformed(ActionEvent a)
   {
        test.label.setText(t.getText());
   }
  }