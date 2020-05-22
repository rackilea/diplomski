import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class CustomJButton extends JButton 
{

    public CustomJButton(String icon)
    {
        super(icon);
        /*int size = 30;
        setPreferredSize(new Dimension(size, size));*/
        addFocusListener(new ButtonFocusAdapter());
        addMouseListener(new ButtonMouseAdapter());
        setContentAreaFilled(false);
        setBorderPainted(false);
        //setFocusable(false);//Don't use this method. This would avoid the focus event on JButton
    }
    private void decorateButton()
    {
        setContentAreaFilled(true);
        setBorderPainted(true);
    }
    private void unDecorateButton()
    {
        setContentAreaFilled(false);
        setBorderPainted(false);
    }
    private class ButtonFocusAdapter extends FocusAdapter
    {
        @Override
        public void focusGained(FocusEvent evt)
        {
            decorateButton();
        }
        @Override
        public void focusLost(FocusEvent evt)
        {
            unDecorateButton();
        }
    }
    private class ButtonMouseAdapter extends MouseAdapter
    {
        @Override
        public void mouseEntered(MouseEvent evt)
        {
            decorateButton();
        }
        @Override 
        public void mouseExited(MouseEvent evt)
        {
            unDecorateButton();
        }
    }
}
public class ButtonFrame extends JFrame
{
    public void createAndShowGUI()
    {
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        for (int i = 0; i < 4 ; i++ )
        {
            CustomJButton cb = new CustomJButton("Button "+i);
            c.add(cb);
        }
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String st[])
    {
        SwingUtilities.invokeLater( new Runnable()
        {
            @Override
            public void run()
            {
                ButtonFrame bf = new ButtonFrame();
                bf.createAndShowGUI();
                bf.setLocationRelativeTo(null);
            }
        });
    }
}