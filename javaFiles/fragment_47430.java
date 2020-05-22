import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PaintingRectangles
{
    private JTextField aboveField;
    private JTextField belowField;
    private JButton applyButton;
    private MyCanvas canvas;

    private void displayGUI()
    {
        JFrame frame = new JFrame("Painting Rectangles Example");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(5, 5));

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(3, 1, 5, 5));
        aboveField = new JTextField(10);
        belowField = new JTextField(10);
        applyButton = new JButton("Apply");
        applyButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                int above = 0;              
                int below = 0;
                try
                {
                    above = Integer.parseInt(aboveField.getText());
                    below = Integer.parseInt(belowField.getText());
                }
                catch(NumberFormatException nfe)
                {
                    aboveField.setText("0");
                    belowField.setText("0");
                    above = 0;
                    below = 0;
                    nfe.printStackTrace();
                }

                canvas.setValues(above, below);
            }
        });

        rightPanel.add(aboveField);
        rightPanel.add(belowField);
        rightPanel.add(applyButton);

        canvas = new MyCanvas();
        contentPane.add(canvas, BorderLayout.CENTER);
        contentPane.add(rightPanel, BorderLayout.LINE_END);

        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new PaintingRectangles().displayGUI();
            }
        });
    }
}

class MyCanvas extends JPanel
{   
    private int midPoint = getHeight() / 2;
    private int rectAbove = getHeight() / 2;
    private int rectBelow = getHeight() / 2;    
    private int width = 40;
    private int heightAbove = 0;
    private int heightBelow = 0;
    private int diff = 0;
    private boolean flag = false;

    public MyCanvas()
    {
        setBackground(Color.GREEN);
    }

    public void setValues(int above, int below)
    {
        midPoint = getHeight() / 2;
        heightAbove = Math.abs(above);
        heightBelow = Math.abs(below);
        /*
         * If both are negative values, 
         * we need a Mid-Point in this case.
         */
        if (above < 0 && below < 0)
        {
            rectAbove = midPoint;
            diff = 120;
            rectBelow = midPoint;
            flag = true;
        }
        else if (above >= 0 && below >= 0)
        {
            rectAbove = getHeight() - heightAbove;
            diff = 120;
            rectBelow = getHeight() - heightBelow;
            flag = false;
        }
        else if (above < 0 && below >= 0)
        {
            rectAbove = midPoint;
            diff = 40;
            rectBelow = midPoint - heightBelow;
            flag = true;
        }
        else if (above >= 0 && below < 0)
        {
            rectAbove = midPoint - heightAbove;
            diff = 40;
            rectBelow = midPoint;
            flag = true;
        }       

        repaint();
    }

    @Override
    public Dimension getPreferredSize()
    {
        return (new Dimension(400, 400));
    }

    @Override
    protected void paintComponent(Graphics g)
    {       
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, getWidth(), getHeight());
        if (flag)
            g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
        makeRectangles(g);
    }

    private void makeRectangles(Graphics g)
    {
        g.setColor(Color.RED);
        g.fillRect(40, rectAbove, width, heightAbove);

        g.setColor(Color.BLUE);
        g.fillRect(diff, rectBelow, width, heightBelow);

        g.dispose();
    }
}