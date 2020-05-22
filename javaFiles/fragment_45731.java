import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * @see
 * http://stackoverflow.com/q/11036830/1057230
 */

public class ColourTimer
{
    private JPanel contentPane;
    private Timer timer;
    private int counter;
    private Color[] colours = {
                                Color.RED,
                                Color.WHITE,
                                Color.BLUE,
                                Color.DARK_GRAY,
                                Color.YELLOW,
                                Color.LIGHT_GRAY,
                                Color.BLACK,
                                Color.MAGENTA,
                                Color.PINK,
                                Color.CYAN
                              };

    private ActionListener timerAction = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent ae)
        {
            if (counter == (colours.length - 1))
                counter = 0;
            contentPane.setBackground(colours[counter++]);
        }    
    };

    public ColourTimer()
    {
        counter = 0;
    }

    private void displayGUI()
    {
        JFrame frame = new JFrame("Colour Timer");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        contentPane = new JPanel();
        contentPane.setOpaque(true);

        final JButton button = new JButton("STOP");
        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                if (timer.isRunning())
                {
                    button.setText("START");
                    timer.stop();
                }
                else
                {
                    button.setText("STOP");
                    timer.start();
                }
            }
        });

        frame.getContentPane().add(contentPane, BorderLayout.CENTER);
        frame.getContentPane().add(button, BorderLayout.PAGE_END);
        frame.setSize(300, 200);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        timer = new Timer(2000, timerAction);
        timer.start();
    }

    public static void main(String... args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new ColourTimer().displayGUI();
            }
        });
    }
}