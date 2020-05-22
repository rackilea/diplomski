import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LabelExample {

    private Timer timer;
    private JButton button;
    private JLabel label;
    private Color[] labelColors = {
        Color.red,
        Color.blue
    };

    private ActionListener timerAction = new ActionListener () {
        private int counter1 = 0;
        private int counter2 = 1;
        @Override
        public void actionPerformed ( ActionEvent ae ) {
            ++counter1;
            counter1 %= labelColors.length;
            label.setBackground ( labelColors [ counter1 ] );
            System.out.println ( "Background Counter: " + counter1 + " Length: " + labelColors.length);
            ++counter2;
            counter2 %= labelColors.length;
            label.setForeground ( labelColors [ counter2 ]);
            System.out.println ( "Foreground Counter: " + counter2 + " Length: " + labelColors.length);
        }
    };

    public LabelExample () {
    }

    private void displayGUI () {
        JFrame frame = new JFrame ( "Label Example" );
        frame.setDefaultCloseOperation ( JFrame.DISPOSE_ON_CLOSE );

        JPanel contentPane = new JPanel ();

        label = new JLabel ( "Hello World!" );
        label.setOpaque ( true );
        label.setBackground ( labelColors [ 0 ] );
        label.setForeground ( labelColors [ 1 ] );

        button = new JButton ( "Stop Timer" );
        button.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed ( ActionEvent ae ) {
                timer.stop ();
            }
        } );

        contentPane.add ( label );
        contentPane.add ( button );

        frame.setContentPane ( contentPane );
        frame.pack ();
        frame.setLocationByPlatform ( true );
        frame.setVisible ( true );

        timer = new Timer ( 1000, timerAction );
        timer.start ();
    }

    public static void main ( String[] args ) {
        Runnable runnable = new Runnable () {
            @Override
            public void run () {
                new LabelExample ().displayGUI ();
            }
        };
        EventQueue.invokeLater ( runnable );
    }
}