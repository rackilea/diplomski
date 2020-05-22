import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import javax.swing.*;

public class SSCCE extends JPanel implements ActionListener
{
    private Timer timer;
    private JLabel label = new JLabel("Press Start");

    public SSCCE()
    {
        setLayout( new BorderLayout(10, 10) );
        add(label, BorderLayout.PAGE_START);


        JButton start = new JButton("Start");
        start.addActionListener( new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                startTimer();
            }
        });
        add(start, BorderLayout.LINE_START);

        JButton stop = new JButton("Stop");
        stop.addActionListener( new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                stopTimer();
            }
        });
        add( stop );
        add(stop, BorderLayout.LINE_END);

        timer = new Timer(1000, this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        label.setText( new Date().toString() );
    }

    private void startTimer()
    {
        timer.start();
    }

    private void stopTimer()
    {
        timer.stop();
    }

    private static void createAndShowGUI()
    {
        JFrame frame = new JFrame("SSCCE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new SSCCE());
        frame.pack();
        frame.setLocationByPlatform( true );
        frame.setVisible( true );
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater( () -> createAndShowGUI() );
/*
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowGUI();
            }
        });
*/
    }
}