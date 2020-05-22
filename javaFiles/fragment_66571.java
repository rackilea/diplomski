import java.awt.*;
import javax.swing.*;
import java.applet.Applet;
import java.awt.event.*;

public class Project2_15 extends Applet
{

    public boolean wink = false;
    Timer timer;

    public void paint(Graphics g)
    {
        super.paint(g);
        // Graphics g; // What do I initialize this to?  ALREADY INITIALIZED
        //paint(g);
        if (wink) {
            g.drawLine(1,1,100,100);
        } else {
            g.drawOval(1,1,100,100);
        }
    }

    // This handles the starting of timer execution.  NO IT DOES NOT!
    // public void start()
    @Override
    public void init()
    {
        setBackground(Color.lightGray);
        timer = new Timer(250,blinkShut);
    }


    @Override
    public void start() {
        timer.start();
    }

    @Override
    public void stop() {
        timer.stop();
    }
    // Timer Stuff
    ActionListener blinkShut = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            wink = !wink;
            repaint();
        }
    };
}