package gui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class LoginPanel extends JPanel
{
    private static final Dimension TFIELD_SZ = new Dimension(120, 20);

    public LoginPanel()
    {
        super(new GridBagLayout());

        final GridBagConstraints cst = new GridBagConstraints();
        cst.insets = new Insets(0, 5, 0, 5);
        cst.weightx = 0.5;
        cst.weighty = 0.5;
        cst.anchor = GridBagConstraints.LINE_START;

        // Username
        cst.gridx = 0;
        cst.gridy = 0;
        this.add(new JLabel("Username:"), cst);
        cst.gridy = 1;
        cst.gridwidth = 2;
        final JTextField uTField = new JTextField();
        uTField.setMinimumSize(TFIELD_SZ);
        uTField.setPreferredSize(TFIELD_SZ);
        this.add(uTField, cst);

        // Password
        cst.gridwidth = 1;
        cst.gridy = 2;
        this.add(new JLabel("Password:"), cst);
        cst.gridy = 3;
        cst.gridwidth = 2;
        final JTextField pwTField = new JTextField();
        pwTField.setMinimumSize(TFIELD_SZ);
        pwTField.setPreferredSize(TFIELD_SZ);
        this.add(pwTField, cst);

        // Buttons
        cst.anchor = GridBagConstraints.CENTER;
        cst.gridy = 4;
        cst.gridwidth = 1;
        this.add(new JButton("Sign in"), cst);
        cst.gridx = 1;
        this.add(new JButton("Sign up"), cst);

    }

    public static void main(final String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                final JDialog myDialog = new JDialog();
                myDialog.setTitle("Sign in");
                myDialog.setSize(180, 170);
                myDialog.setContentPane(new LoginPanel());
                myDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                myDialog.setVisible(true);
            }
        });
    }
}