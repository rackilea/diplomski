import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UpdateWithTimer extends JFrame
{
    private Timer timer;
    private JButton startStopButton;
    private JLabel changingLabel;
    private int counter = 0;
    private boolean flag = false;
    private ActionListener timerAction = new ActionListener()
    {
        public void actionPerformed(ActionEvent ae)
        {
            counter++;
            changingLabel.setText("" + counter);
        }
    };

    private ActionListener buttonAction = new ActionListener()  
    {
        public void actionPerformed(ActionEvent ae)
        {
            if (!flag)
            {
                startStopButton.setText("STOP TIMER");
                timer.start();
                flag = true;
            }
            else if (flag)
            {
                startStopButton.setText("START TIMER");
                timer.stop();
                flag = false;
            }
        }
    };

    private void createAndDisplayGUI()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationByPlatform(true);

        JPanel contentPane = new JPanel();
        changingLabel = new JLabel("" + counter);
        contentPane.add(changingLabel);

        startStopButton = new JButton("START TIMER");
        startStopButton.addActionListener(buttonAction);

        add(contentPane, BorderLayout.CENTER);
        add(startStopButton, BorderLayout.PAGE_END);

        timer = new Timer(1000, timerAction);

        setSize(300, 300);
        setVisible(true);
    }

    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new UpdateWithTimer().createAndDisplayGUI();
            }
        });
    }
}