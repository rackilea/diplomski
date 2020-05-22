import java.awt.*;
import javax.swing.*;

public class BoxExample extends JFrame
{
    public BoxExample()
    {
        Box box = Box.createVerticalBox();
        add( box );

        JLabel above = new JLabel("Above");
        above.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        box.add( above );

        JLabel below = new JLabel("Below");
        below.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        box.add( below );
    }

    public static void main(String[] args)
    {
        BoxExample frame = new BoxExample();
        frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
        frame.pack();
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);
    }
}