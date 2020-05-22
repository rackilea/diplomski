import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonCalculator extends JFrame implements ActionListener
{
    private JButton[] buttons;
    private JTextField display;

    public ButtonCalculator()
    {
        display = new JTextField();
        display.setEditable( false );
        display.setHorizontalAlignment(JTextField.RIGHT);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout( new GridLayout(0, 5) );
        buttons = new JButton[10];

        for (int i = 0; i < buttons.length; i++)
        {
            String text = String.valueOf(i);
            JButton button = new JButton( text );
            button.addActionListener( this );
            button.setMnemonic( text.charAt(0) );
            buttons[i] = button;
            buttonPanel.add( button );
        }

        getContentPane().add(display, BorderLayout.NORTH);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        setResizable( false );
    }

    public void actionPerformed(ActionEvent e)
    {
        JButton source = (JButton)e.getSource();
        display.replaceSelection( source.getActionCommand() );
    }

    public static void main(String[] args)
    {
        UIManager.put("Button.margin", new Insets(10, 10, 10, 10) );
        ButtonCalculator frame = new ButtonCalculator();
        frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
        frame.pack();
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);
    }
}