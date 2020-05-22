import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.ArrayList;

// 1 - turtle up
// 2 - turtle down/draw
// 3 - turn right
// 4 - turn left
// 5 - move forward a number of steps
// 6 - display drawing

class Line {
    int startX;
    int startY;
    int endX;
    int endY;

    Line(int startX, int startY, int endX, int endY)
    {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }
}

public class TurtleGraphics2D extends JPanel implements ActionListener
{
    private static final int FLOORSIZE = 400;

    private static Box box;
    private JTextField textField;
    private JButton drawButton;
    private int currentXPosition = 0; 
    private int currentYPosition = 0; 
    private int heading = 0;  // initial heading is South
    private boolean isDown = false; // to know when pen is up or down

    private ArrayList<Line> lines = new ArrayList<>(); // a collection of lines to (re)draw

    public TurtleGraphics2D()
    {
        box = Box.createVerticalBox();

        textField = new JTextField("Enter Command...");
        drawButton = new JButton("Display Drawing");

        box.add(textField);
        box.add(drawButton);

        textField.addActionListener(this);
        drawButton.addActionListener(this);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        for (Line line: lines)
        {
            g.drawLine(line.startX, line.startY, line.endX, line.endY);
        }
    }

    public void actionPerformed(ActionEvent event)
    {
        if (event.getSource() == textField)
        {
            try
            {
                int command = Integer.parseInt(textField.getText());
                textField.setText("");

                switch(command)
                {
                    case 1:
                        isDown = false;
                        break;
                    case 2:
                        isDown = true;
                        break;
                    case 3: // right / clockwise
                        if (++heading > 3)
                        {
                            heading -= 4;
                        }
                        break;
                    case 4: // left / counterclockwise
                        if (--heading < 0)
                        {
                            heading += 4;
                        }
                        break;
                    case 5:
                        int steps = Integer.parseInt(JOptionPane.showInputDialog("Steps: "));

                        int prevX = currentXPosition;
                        int prevY = currentYPosition;

                        for (int i = 0; i < steps; i++)
                        {
                            if (heading == 0) // cursor South
                            {
                                // this condition ensures ArrayIndexOutOfBoundsException is avoided
                                if (++currentYPosition > FLOORSIZE)
                                {
                                    currentYPosition--;
                                }
                            }
                            else if (heading == 1) // cursor West
                            {
                                if (--currentXPosition < 0)
                                {
                                    currentXPosition++;
                                }
                            }
                            else if (heading == 2) // cursor North
                            {
                                if (--currentYPosition < 0)
                                {
                                    currentYPosition++;
                                }
                            }
                            else if (heading == 3) // cursor East
                            {
                                if (++currentXPosition > FLOORSIZE)
                                {
                                    currentXPosition--;
                                }
                            }
                        }

                        if (isDown)
                        {
                            lines.add(new Line(prevX, prevY, currentXPosition, currentYPosition));
                        }

                        break;
                    case 6:
                        repaint();
                        break;
                    default:
                        break;
                    }

                }
                catch(IllegalArgumentException ex)
                {
                    JOptionPane.showMessageDialog(null, "Invalid Command", "Error Message", JOptionPane.ERROR_MESSAGE);
                    System.err.println("Invalid command");
                }
            }
            else if (event.getSource() == drawButton)
            {
                repaint();
            }
        }

    public static void main(String args[])
    {
        JFrame frame = new JFrame();
        TurtleGraphics2D panel = new TurtleGraphics2D();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        frame.add(box, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}