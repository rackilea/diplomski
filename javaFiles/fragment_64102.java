import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonPopUp
{
    private static final int SIZE = 30;
    private JButton[] button = new JButton[SIZE];
    private JPopupMenu popup = new JPopupMenu("Hello World");

    private void createAndDisplayGUI()
    {
        JFrame frame = new JFrame("Button POP UP Example");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationByPlatform(true);

        final JPanel contentPane = new JPanel();
        contentPane.setLayout(new GridLayout(0, 5));

        JMenuItem menuItem1 = new JMenuItem("Menu Item 1");
        JMenuItem menuItem2 = new JMenuItem("Menu Item 2");
        //popup.add(greetings);
        popup.insert(menuItem1, 0);
        popup.insert(menuItem2, 1);

        for (int i = 0; i < SIZE; i++)
        {
            button[i] = new JButton();
            button[i].setBorder(BorderFactory.createEtchedBorder());
            button[i].addMouseListener(new MouseAdapter()
            {
                public void mouseClicked(MouseEvent me)
                {
                    System.out.println("I am WORKING!!");
                    popup.show((JComponent)me.getSource(), me.getX(), me.getY());
                }
            });
            contentPane.add(button[i]);
        }

        frame.getContentPane().add(contentPane);
        frame.setSize(175, 250);
        frame.setVisible(true);
    }

    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new ButtonPopUp().createAndDisplayGUI();
            }
        });
    }
}