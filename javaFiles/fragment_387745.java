import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;

public class StateChangedEventClass extends JFrame
{
    private JPanel contentPane, panel1, panel2;
    private JButton clearButton;
    private ItemListener itemChangeAction;
    private CaretListener caretAction;

    public StateChangedEventClass()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setLayout(new GridLayout(2, 2));
        clearButton = new JButton("CLEAR");
        clearButton.setEnabled(false);

        itemChangeAction = new ItemListener()
        {
            public void itemStateChanged(ItemEvent ce)
            {
                clearButton.setEnabled(true);
            }
        };

        caretAction = new CaretListener()
        {
            public void caretUpdate(CaretEvent ce)
            {
                clearButton.setEnabled(true);
            }
        };

        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(2  , 2));
        JLabel userLabel = new JLabel("USERNAME : ", JLabel.CENTER);
        JTextField userField = new JTextField(10);
        userField.addCaretListener(caretAction);
        JLabel passLabel = new JLabel("PASSWORD : " + JLabel.CENTER);
        JTextField passField = new JTextField(10);
        passField.addCaretListener(caretAction);
        panel1.add(userLabel);
        panel1.add(userField);
        panel1.add(passLabel);
        panel1.add(passField);
        contentPane.add(panel1);

        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(2, 1));
        JRadioButton maleButton = new JRadioButton("MALE", false);
        maleButton.addItemListener(itemChangeAction);
        JRadioButton femaleButton = new JRadioButton("FEMALE", false);
        femaleButton.addItemListener(itemChangeAction);
        ButtonGroup bg = new ButtonGroup();
        bg.add(maleButton);
        bg.add(femaleButton);
        panel2.add(maleButton);
        panel2.add(femaleButton);
        contentPane.add(panel2);

        add(contentPane, BorderLayout.CENTER);
        add(clearButton, BorderLayout.PAGE_END);

        pack();
        setVisible(true);
    }

    public void caretUpdate(CaretEvent ce)
    {
        clearButton.setEnabled(true);
    }

    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new StateChangedEventClass();
            }
        });
    }
}