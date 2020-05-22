import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyBindingExample
{
    private void createAndDisplayGUI()
    {
        JFrame frame = new JFrame("Key Binding Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DrawingPanel contentPane = new DrawingPanel();
        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        contentPane.requestFocusInWindow();
    }

    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new KeyBindingExample().createAndDisplayGUI();
            }
        });
    }
}

class DrawingPanel extends JPanel
{
    private int x;
    private int y;
    private String[] commands = {
                                    "UP",
                                    "DOWN",
                                    "LEFT",
                                    "RIGHT"
                                };                      

    private ActionListener panelAction = new ActionListener()
    {   
        @Override
        public void actionPerformed(ActionEvent ae)
        {
            String command = (String) ae.getActionCommand();
            if (command.equals(commands[0]))
                y -= 1;             
            else if (command.equals(commands[1]))
                y += 1;
            else if (command.equals(commands[2]))
                x -= 1;
            else if (command.equals(commands[3]))
                x += 1;

            repaint();  
        }
    };

    public DrawingPanel()
    {
        x = 0;
        y = 0;

        for (int i = 0; i < commands.length; i++)       
            registerKeyboardAction(panelAction,
                            commands[i],
                            KeyStroke.getKeyStroke(commands[i]),
                            JComponent.WHEN_IN_FOCUSED_WINDOW);
    }

    @Override
    public Dimension getPreferredSize()
    {
        return (new Dimension(500, 300));
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        String displayText = "X : " + x + " and Y : " + y;
        System.out.println(displayText);
        g.drawString(displayText, x, y);
    }
}