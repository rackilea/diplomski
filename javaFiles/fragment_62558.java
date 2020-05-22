import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class  DoublePanel extends JFrame
{
    JPanel mainPanel;
    int x1;
    public void prepareAndShowGUI()
    {
        setTitle("DoublePanel");
        mainPanel = new JPanel()
        {
            @Override
            public void paintComponent(Graphics g)
            {
                super.paintComponent(g);
                g.setColor(Color.BLACK);
                g.drawLine(x1,0,x1,this.getHeight());
            }
        };
        mainPanel.setBackground(new Color(50,160,55));
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(new upperPanel(this));
        setContentPane(mainPanel);
        setSize(500,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
    public void setXValue(int x)
    {
        this.x1 = x;
        mainPanel.repaint();
    }
    class upperPanel extends JPanel
    {
        int x; int y;
        DoublePanel dp;
        upperPanel(DoublePanel d)
        {
            this.dp = d;
            setOpaque(false);
            addMouseMotionListener(new MouseAdapter()
            {
                @Override
                public void mouseMoved(MouseEvent evt)
                {
                    x = evt.getX();
                    y = evt.getY();
                    repaint();
                }
            });
            addMouseListener(new MouseAdapter()
            {
                @Override
                public void mouseClicked(MouseEvent evt)
                {
                    dp.setXValue(evt.getX());
                }
            });
        }
        @Override
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            g.setColor(Color.RED);
            g.drawLine(x,0,x,this.getHeight());
        }
    }
    public static void main(String st[])
    {
        SwingUtilities.invokeLater( new Runnable()
        {
            public void run()
            {
                DoublePanel dp = new DoublePanel();
                dp.prepareAndShowGUI();
            }
        });
    }
}