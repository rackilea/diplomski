import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
class MouseClickOnJLabel extends JFrame 
{
    public void createAndShowGUI()
    {
        JLabel label = new JLabel("Double Click on me!!");
        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(label);
        label.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent evt)
            {
                int count = evt.getClickCount();
                if (count == 2)
                {
                    JOptionPane.showMessageDialog(MouseClickOnJLabel.this,"You double clicked on JLabel","Information",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        setSize(300,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater( new Runnable()
        {
            public void run()
            {
                MouseClickOnJLabel moj = new MouseClickOnJLabel();
                moj.createAndShowGUI();
            }
        });
    }
}