import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawingCircleExample {

    private JPanel drawingBoard;
    private JButton button;

    private static final int GAP = 5;

    private void displayGUI () {
        JFrame frame = new JFrame ( "" );
        frame.setDefaultCloseOperation ( JFrame.DISPOSE_ON_CLOSE );

        JPanel contentPane = new JPanel ();
        contentPane.setLayout ( new BorderLayout ( GAP, GAP ) );
        drawingBoard = new DrawingBoard ();
        contentPane.add ( drawingBoard, BorderLayout.CENTER );

        button = new JButton ( "Draw" );
        button.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed ( ActionEvent ae ) {
                 DrawingBoard board = ( DrawingBoard ) drawingBoard;
                 board.setState ();
            }
        } );
        contentPane.add ( button, BorderLayout.PAGE_END );

        frame.setContentPane ( contentPane );
        frame.pack ();
        frame.setLocationByPlatform ( true );
        frame.setVisible ( true );
    }

    public static void main ( String [] args ) {
        Runnable runnable = new Runnable () {
            @Override
            public void run () {
                new DrawingCircleExample ().displayGUI ();
            }
        };
        EventQueue.invokeLater ( runnable );
    }
}

class DrawingBoard extends JPanel {

    private static final int TOTAL_RECTANGLES = 5;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private static final int RADIUS = 50;
    private static final int X = 50;
    private static final int Y = 50;
    private int counter;
    private int moveXBy;
    private boolean isActive;
    private int count;

    public DrawingBoard () {
        setOpaque ( true );
        counter = 0;
        count = 0;
        isActive = false;
        moveXBy = ( RADIUS + ( counter ) * RADIUS );
    }

    public boolean setState () {        
        isActive = true;
        System.out.println ( "Outside MoveXBy: " + moveXBy );
        ++counter;
        counter %= TOTAL_RECTANGLES;
        int x = ( RADIUS + ( counter ) * RADIUS );
        if ( moveXBy != x ) {
            System.out.println ( "Inside First MoveXBy: " + moveXBy );
            repaint ( moveXBy, RADIUS, X, Y );
            moveXBy = x;
            System.out.println ( "Inside Second MoveXBy: " + moveXBy );
            repaint ( moveXBy, RADIUS, X, Y );          
        }       

        return isActive;
    }

    @Override
    public Dimension getPreferredSize () {
        return new Dimension ( WIDTH, HEIGHT );
    }

    @Override
    protected void paintComponent ( Graphics g ) {
        super.paintComponent ( g );
        g.drawRect ( 50, RADIUS, X, Y );
        g.drawRect ( 100, RADIUS, X, Y );
        g.drawRect ( 150, RADIUS, X, Y );
        g.drawRect ( 200, RADIUS, X, Y );
        g.drawRect ( 250, RADIUS, X, Y );

        g.setColor ( Color.RED );
        g.fillOval ( moveXBy, RADIUS, X, Y ) ;
    }
}