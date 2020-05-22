import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.border.*;

public class IconBorder implements Border
{
    private Icon icon;
    private Insets borderInsets = new Insets(0, 0, 0, 0);

    public IconBorder(Icon icon)
    {
        this.icon = icon;
    }
//
//  Implement the Border interface
//
    @Override
    public Insets getBorderInsets(Component c)
    {
        return borderInsets;
    }

    @Override
    public boolean isBorderOpaque()
    {
        return false;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height)
    {
        icon.paintIcon(c, g, x+1, y+1);
    }

    private static void createAndShowUI()
    {
        JPanel panel = new JPanel();
        panel.add( createTextField( new Ellipse2D.Double(0, 0, 30, 30) ) );

        JFrame frame = new JFrame("SSCCE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( panel );
        frame.setLocationByPlatform( true );
        frame.pack();
        frame.setVisible( true );
    }

    private static JTextField createTextField(Shape shape)
    {
        JTextField textField = new JTextField(1);
        textField.setFont( new Font("Serif", Font.PLAIN, 18) );

        OutlineIcon icon = new OutlineIcon(shape, Color.RED, 2);
        CompoundBorder inner = new CompoundBorder( textField.getBorder(), new EmptyBorder(5, 10, 5, 10) );
        CompoundBorder border = new CompoundBorder(new IconBorder(icon), inner);
        textField.setBorder( border );

        return textField;
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