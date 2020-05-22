import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class SimpleTimer extends JFrame implements ActionListener 
{
    private JLabel label;
    private Timer timer;
    private int counter = 10; // the duration
    private int delay = 1000; // every 1 second
    private static final long serialVersionUID = 1L;

    public SimpleTimer()
    {
        super("Simple Timer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 65);
        label = new JLabel("Wait for " + counter + " sec");
        getContentPane().add(label);
        timer = new Timer(delay, this);
        timer.setInitialDelay(0);
        timer.start();
        setVisible(true);
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new SimpleTimer();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(counter == 0)
        {
            timer.stop();
            label.setText("The time is up!");
        }
        else
        {
            label.setText("Wait for " + counter + " sec");
            counter--;
        }
    }
}