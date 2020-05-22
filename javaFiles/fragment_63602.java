import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Action;

public class ButtonExample
{
    private JFrame frame;
    private JButton button;

    private void displayGUI()
    {
        frame = new JFrame("Button Mnemonic Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel();      
        Action buttonAction = new ButtonAction("CLICK ME"
                                , "This is a Click Me JButton");
        button = new JButton(buttonAction);                                             
        button.getInputMap().put(KeyStroke.getKeyStroke('c'), "Click Me Button");
        button.getActionMap().put("Click Me Button", buttonAction);

        contentPane.add(button);
        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    class ButtonAction extends AbstractAction
    {
        public ButtonAction(String text, String desc)
        {
            super(text);
            putValue(SHORT_DESCRIPTION, desc);
        }

        @Override
        public void actionPerformed(ActionEvent ae)
        {
            JOptionPane.showMessageDialog(frame, "BINGO, you SAW me.");
        }
    }

    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new ButtonExample().displayGUI();
            }
        });
    }
}