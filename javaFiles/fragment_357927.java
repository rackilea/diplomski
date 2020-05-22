import java.awt.*;
import javax.swing.*;

public class RelativeSSCCE extends JPanel
{
    public RelativeSSCCE()
    {
        JPanel left = new JPanel( new FlowLayout(FlowLayout.LEFT) );
        left.add( new JButton("L1") );
        left.add( new JButton("L2") );
        left.add( new JButton("L3") );

        JLabel center = new JLabel("Centered");

        JPanel right = new JPanel( new FlowLayout(FlowLayout.RIGHT) );
        right.add( new JButton("Right1") );
        right.add( new JButton("Right2") );
        right.add( new JButton("Right3") );

        // choose your layout manager here

        setLayout( new RelativeLayout() );
        Float ratio = new Float(1);
        add(left, ratio);
        add(center);
        add(right, ratio);
    }

    private static void createAndShowUI()
    {
        JFrame frame = new JFrame("Basic RelativeSSCCE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( new RelativeSSCCE() );
        frame.setSize(600, 100);
        frame.setLocationRelativeTo( null );
        frame.setVisible( true );
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowUI();
            }
        });
    }
}