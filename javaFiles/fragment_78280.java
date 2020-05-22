import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class XFrame
    extends JFrame
{
    public XFrame(String title)
    {
        super(title);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JRadioButton b1 = new JRadioButton("Non opaque button");
        // button must not be opaque
        b1.setOpaque(false);

        // this button is opaque and does not use the background color of the frame
        JRadioButton b2 = new JRadioButton("Opaque button");

        JPanel p1 = new JPanel();
        // panel must be non opaque also
        p1.setOpaque(false);

        p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
        p1.add(b1);
        p1.add(b2);

        add(p1, BorderLayout.CENTER);

        getContentPane().setBackground(Color.red);

        setSize(200, 200);
    }

    public static void main(String[] args)
    {
        XFrame frame = new XFrame("Test");
        frame.setVisible(true);
    }

}