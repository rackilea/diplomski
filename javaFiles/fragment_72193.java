import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MovingCircleGUI
{
    JFrame frame;

    public int x,y;
    public int vx = 10,vy=5;
    public int width = 500,height = 500;
    public int diameter=50;

    CircleDrawPanel drawPanel;
    Color color = Color.magenta.darker();
    JButton button;
    Timer timer2 = new Timer(25, new AnimateCircleListener());

    boolean isRunning = false;

    public static void main (String[] args)
    {
        MovingCircleGUI gui = new MovingCircleGUI();
        gui.go();
    }

    //this method sets up the JFrame and adds the draw panel to the frame
    public void go()
    {
        frame = new JFrame("MovingCircleGUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        drawPanel = new CircleDrawPanel();
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);

        button = new JButton("Click me to start the animation");
        drawPanel.add(button);
        frame.getContentPane().add(BorderLayout.SOUTH , button);
        button.addActionListener(new  AnimateCircleListener());

        frame.setSize(width,height);
        frame.setVisible(true);
    }

    class CircleDrawPanel extends JPanel
    {
        public void paintComponent (Graphics g)
        {
            super.paintComponent(g);
            Graphics2D g2=(Graphics2D)g;
            g2.setColor(color);
            g2.fillOval(x,y,diameter,diameter);
        }
    }

    public void MovingBall()
    {
        x = x + vx;
        y = y + vy;

        if( y >= height)
        {
            y=0;
            boolean xIsSame = true;
            int randomX = 0;
            do
            {
                randomX = Math.round((float)Math.random()*width);

                if (randomX != x)
                {
                    x = randomX;
                }

            }
            while(!xIsSame);
        }

        if(x <= 0)
        {
            x = width+x;
        }

        if (x >= width)
        {
            x = x-width;
        }

        frame.repaint();
    }

    class AnimateCircleListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            if(e.getSource()== button)
            {
                if(timer2.isRunning())
                {
                    button.setText("Click me to start the animation");
                    button.revalidate();
                    timer2.stop();
                }
                else
                {
                    button.setText("Click me to stop the animation");
                    button.revalidate();
                    timer2.start();
                }
            }

            if(e.getSource()==timer2)
            {
                MovingBall();
            }
        }
    }

    public int getX() 
    {
        return x;
    }

    public void setX(int x) 
    {
        this.x = x;
    }

    public int getY() 
    {
        return y;
    }

    public void setY(int y) 
    {
        this.y = y;
    }
}