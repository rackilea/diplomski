import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyBindingExample
{
    private DrawingBoard contentPane;
    /*
     * There variables will simply
     * decide how much the square
     * will move with click key press,
     * in this case I have set this to
     * 1 (inside the constructor).
     * brakes will simply tell whether
     * the square will move or not in
     * a given direction.
     */
    private int speed;
    private int brakes;

    public KeyBindingExample() {
        speed = 5;
        brakes = 0;
    }

    private void displayGUI()
    {
        JFrame frame = new JFrame("Swing Worker Example");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        contentPane = new DrawingBoard(10, 10, Color.BLUE.darker());

        addBindingsToBoard();

        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    private void addBindingsToBoard() {
        /*
         * Since, when UP Arrow is pressed, that means, the square
         * can move vertically upwards, hence, the square will move
         * along Y-Axis that too in the negative direction of the 
         * same, though along X-Axis the square will move nowhere,
         * hence, we passing 0 and -1, since we want to add the 
         * current location (say square is at present at 50, 50),
         * now after UP Arrow key event, square will be at (50, 49);
         */
        putBindingsFor(contentPane, KeyStroke.getKeyStroke("UP"),
                                "UP Arrow Key", brakes, -speed);
        /*
         * When RIGHT Arrow is pressed, the square is suppose to
         * move horizontally, along the X-Axis, in the positive
         * direction towards the RIGHT. Hence +1 change along X-Axis
         * and no change along Y-Axis, i.e. from (50, 49), the square
         * will now move to (51, 49), that's why we passing (+1, 0)
         */
        putBindingsFor(contentPane, KeyStroke.getKeyStroke("RIGHT"),
                                "RIGHT Arrow Key", speed, brakes);
        /*
         * When DOWN Arrow is pressed, the square is suppose to
         * move vertically, along the Y-Axis, in the positive
         * direction towards the BOTTOM. Hence no change along X-Axis
         * and +1 change along Y-Axis, i.e. from (51, 49), the square
         * will now move to (51, 50), that's why we passing (0, +1)
         */
        putBindingsFor(contentPane, KeyStroke.getKeyStroke("DOWN"),
                                "DOWN Arrow Key", brakes, +speed);
        /*
         * When LEFT Arrow is pressed, the square is suppose to
         * move horizontally, along the X-Axis, in the negative
         * direction towards the LEFT side. Hence -1 change along X-Axis
         * and no change along Y-Axis, i.e. from (51, 50), the square
         * will now move to (50, 50), that's why we passing (-1, 0).
         * The square will atlast come to it's initial position.
         */
        putBindingsFor(contentPane, KeyStroke.getKeyStroke("LEFT"),
                                "LEFT Arrow Key", -speed, brakes);
    }

    private void putBindingsFor(JComponent comp,
        KeyStroke keyStroke, String value, final int moveX, final int moveY) {
        comp.getInputMap().put(keyStroke, value);
        comp.getActionMap().put(value, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                contentPane.setValues(moveX, moveY);
            }
        });
    }

    public static void main(String[] args)
    {
        Runnable runnable = new Runnable()
        {
            @Override
            public void run()
            {
                new KeyBindingExample().displayGUI();
            }
        };
        EventQueue.invokeLater(runnable);
    }
}

class DrawingBoard extends JPanel {

    private int x;
    private int y;
    private int width;
    private int height;
    private Color rectColor;

    public DrawingBoard(int x, int y, Color rColor) {
        setOpaque(true);
        this.x = x;
        this.y = y;
        rectColor = rColor;
        width = height = 10;
    }

    public void setValues(int deltaX, int deltaY) {

        System.out.format("Firstly X : %d\tY : %d%n", x, y);
        repaint(x, y, width, height);
        /*
         * Whatever values are passed from above, i.e.
         * say on Left ARROW, we passing (-1, 0),
         * therefore deltaX will be -1 and deltaY will
         * be 0. Now whatever the current value of X is
         * we are simply adding deltaX to that value
         * and the same goes for deltaY as well.
         * Now since the value for x and y is updated
         * after these two statements below, we checking
         * that whether these two updated values lies
         * within the bounds of our board or not.
         * If they are, then we simply calling repaint,
         * to draw the square at this new location, else
         * we simply bring back the previous values of 
         * x and y to their previous state.
         */
        x += deltaX;
        y += deltaY;

        if ((x + width) <= getWidth() && (y + height) <= getHeight()
                        && x >= 0 && y >= 0) {
            System.out.format("Later X : %d\tY : %d%n", x, y);
            repaint(x, y, width, height);
        }
        else {
            x -= deltaX;
            y -= deltaY;
            System.out.format("Later X : %d\tY : %d%n", x, y);
            repaint(x, y, width, height);
        }
    }

    /*
     * Make this a customary habbit of overridding
     * this method whenever you have to override
     * any JComponent, instead of calling
     * setPreferredSize(...).
     */
    @Override
    public Dimension getPreferredSize() {
        return (new Dimension(100, 100));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(rectColor);
        g.fillRect(x, y, width, height);
    }
}