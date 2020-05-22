import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FlowLayoutInvisible extends JFrame
    implements ActionListener
{
    JPanel north;
    int i;

    public FlowLayoutInvisible()
    {

        north = new JPanel();

        for (int i = 0; i < 5; i++)
        {
            JButton button = new JButton("North - " + i);
            button.addActionListener(this);
            north.add(button);
        }

        getContentPane().add(north, BorderLayout.NORTH);
        }

    public void actionPerformed(ActionEvent e)
    {
        Component c = (Component)e.getSource();
        c.setVisible(false);
    ((JPanel)c.getParent()).revalidate();
    }

    public static void main(String[] args)
    {
        FlowLayoutInvisible frame = new FlowLayoutInvisible();
        frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
        frame.pack();
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);
    }
}