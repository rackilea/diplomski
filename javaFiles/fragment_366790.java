import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Paint {

    public static void main(String[] args) {
        PaintWindow frame = new PaintWindow();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}

class PaintWindow extends JFrame {

    public PaintWindow() {
        setTitle(" Paint");
        setSize(700, 600);

        panel = new JPanel();
        drawPad = new PadDraw();

        panel.setPreferredSize(new Dimension(100, 68));

//Creates a new container
        Container content = this.getContentPane();
        content.setLayout(new BorderLayout());

//sets the panel to the left, padDraw in the center (To the right of it)
        content.add(panel, BorderLayout.WEST);
        content.add(drawPad, BorderLayout.CENTER);




//add the color buttons:
        makeColorButton(Color.MAGENTA);
        makeColorButton(Color.BLUE);
        makeColorButton(Color.CYAN);
        makeColorButton(Color.GREEN);
        makeColorButton(Color.YELLOW);
        makeColorButton(Color.ORANGE);
        makeColorButton(Color.RED);
        makeColorButton(Color.PINK);
        makeColorButton(Color.LIGHT_GRAY);
        makeColorButton(Color.GRAY);
        makeColorButton(Color.DARK_GRAY);
        makeColorButton(Color.BLACK);

//creates the eraser (Draws the background color which is white)
        JButton eraserButton = new JButton("Eraser");
        eraserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                drawPad.changeColor(Color.white);
            }
        });
        panel.add(eraserButton);

//creates the clear button
        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                drawPad.clear();
            }
        });
        panel.add(clearButton);

        JButton brush1Button = new JButton("Brush 1");
        brush1Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//here     
                PadDraw.stroke = 10;
            }
        });
        panel.add(brush1Button);

        JButton brush2Button = new JButton("Brush 2");
        brush2Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PadDraw.stroke = 15;
//stuff here
            }
        });
        panel.add(brush2Button);

        JButton saveButton = new JButton("Save As");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BufferedImage image = new BufferedImage(drawPad.getWidth(), drawPad.getHeight(), BufferedImage.TYPE_INT_RGB);
                //Graphics2D graphics2D = image.createGraphics(); 
                //drawPad.paint(graphics2D);
                try {
                    ImageIO.write(image, "png", new File("C:/.../Desktop/Example.png"));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
        panel.add(saveButton);

    }


    /*
     * makes a button that changes the color
     * the color used for the button
     */
    public void makeColorButton(final Color color) {
        JButton tempButton = new JButton();
        tempButton.setBackground(color);
        tempButton.setPreferredSize(new Dimension(20, 20));
        panel.add(tempButton);
        tempButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                drawPad.changeColor(color);
            }
        });
    }
    private JPanel panel;
    private PadDraw drawPad;
}

class PadDraw extends JComponent {
    //default value of stroke is 5
    static int stroke = 5;
//this is gonna be your image that you draw on
    Image image;
//this is what we'll be using to draw on
    Graphics2D graphics2D;
//these are gonna hold our mouse coordinates
    int currentX, currentY, oldX, oldY;

    public PadDraw() {
        setDoubleBuffered(false);
        addMouseListener(new MouseAdapter() {
//if the mouse is pressed it sets the oldX & oldY
//coordinates as the mouses x & y coordinates 
            //Thsi allows click and drag
            public void mousePressed(MouseEvent e) {
                oldX = e.getX();
                oldY = e.getY();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
//while the mouse is dragged it sets currentX & currentY as the mouses x and y
//then it draws a line at the coordinates
//it repaints it and sets oldX and oldY as currentX and currentY
            public void mouseDragged(MouseEvent e) {
                currentX = e.getX();
                currentY = e.getY();

//draws a line
//graphics2D.drawLine(oldX, oldY, currentX, currentY);

//
//graphics2D.fillOval( (oldX-5), (oldY-5), 10, 10); 
//repaint();

//variable brush size here
                int nBsize;
                nBsize = stroke;

                graphics2D.fillOval((oldX - (nBsize / 2)), (oldY - (nBsize / 2)), nBsize, nBsize);
                repaint();

                oldX = currentX;
                oldY = currentY;
            }
        });
    }

//this is the painting bit.
//if it has nothing on it then
//it creates an image the size of the window
//sets Graphics as the image
//sets the rendering
//then runs the clear() method
//then it draws the image
    public void paintComponent(Graphics g) {

        if (image == null) {
            image = createImage(getSize().width, getSize().height);
            graphics2D = (Graphics2D) image.getGraphics();
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            clear();
        }

        g.drawImage(image, 0, 0, null);
    }

//this is the clear
//it sets the color as white
//then it fills the window with white
//then it sets the color back to black
    public void clear() {
        graphics2D.setPaint(Color.white);
        graphics2D.fillRect(0, 0, getSize().width, getSize().height);
        graphics2D.setPaint(Color.black);
        repaint();
    }

    public void changeColor(Color theColor) {
        graphics2D.setPaint(theColor);
        repaint();
    }
}