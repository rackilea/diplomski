import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonTest extends JFrame implements ActionListener
{
    private JTabbedPane tabbedPane;
    private JButton focusButton;
    private JPanel contentPane, tab1, tab2;
    private JTextField textField1, textField2, textField3;

    public ButtonTest()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tab1 = new JPanel();
        textField1 = new JTextField(10);
        textField1.requestFocusInWindow();
        tab1.add(textField1);

        tab2 = new JPanel();
        textField2 = new JTextField(10);
        textField3 = new JTextField(10);
        tab2.add(textField2);
        tab2.add(textField3);

        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());

        tabbedPane = new JTabbedPane(JTabbedPane.TOP,
                                                JTabbedPane.WRAP_TAB_LAYOUT);
        tabbedPane.addTab("TAB 1", null, tab1, "I am TAB 1");
        tabbedPane.addTab("TAB 2", null, tab2, "I am TAB 2");

        focusButton = new JButton("CHANGE FOCUS");
        //focusButton.addMnemonic(KeyEvent.VK_ENTER); /* You can Add this Line too
                                                      /* , to make it work. But here
                                                       * you have to press ALT + ENTER.
                                                       */
        getRootPane().setDefaultButton(focusButton);
        focusButton.addActionListener(this);

        contentPane.add(tabbedPane, BorderLayout.CENTER);
        contentPane.add(focusButton, BorderLayout.PAGE_END);
        setContentPane(contentPane);
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if (tabbedPane.getSelectedIndex() == 0)
        {
            tabbedPane.setSelectedIndex(1);
            textField3.requestFocusInWindow();
        }
        else if (tabbedPane.getSelectedIndex() == 1)
        {
            tabbedPane.setSelectedIndex(0);
            textField1.requestFocusInWindow();
        }
    }

    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new ButtonTest();
            }
        });
    }
}