import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DialogFocus 
{
    private JFrame frame;
    private MyDialog myDialog;

    public DialogFocus()
    {
    }

    private void createAndDisplayGUI()
    {
        frame = new JFrame("JFRAME");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);

        myDialog = new MyDialog(frame, "My Dialog", false);

        JButton showButton = new JButton("SHOW DIALOG");
        showButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                if (!(myDialog.isShowing()))
                    myDialog.setVisible(true);
            }
        });

        frame.add(showButton, BorderLayout.PAGE_END);

        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    public static void main(String\u005B\u005D args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new DialogFocus().createAndDisplayGUI();
            }
        });
    }
}

class MyDialog extends JDialog
{
    private WindowFocusListener windowFocusListener;

    public MyDialog(JFrame frame, String title, boolean isModal)
    {
        setTitle(title);
        setModal(isModal);

        JPanel contentPane = new JPanel();

        JTextField tfield = new JTextField(10);
        JComboBox cbox = new JComboBox();
        cbox.addItem("One");
        cbox.addItem("Two");
        cbox.addItem("Three");

        contentPane.add(tfield);
        contentPane.add(cbox);

        windowFocusListener = new WindowFocusListener()
        {
            public void windowGainedFocus(WindowEvent we)
            {
            }

            public void windowLostFocus(WindowEvent we)
            {
                setVisible(false);
            }
        };

        addWindowFocusListener(windowFocusListener);

        add(contentPane);
        pack();
    }
}