import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Timer;

public class UserSignIn  extends JFrame implements ActionListener{
    private static JLabel lblUserName;
    private static JTextField txtUserName;
    private static JButton btnSignIn;
    private static JLabel lblPassword;
    private static JPasswordField txtPassword;
    private static JButton btnCancel;
    private static JTabbedPane tabbedPane;

    public static void main(String[] args) {
        UserSignIn frame = new UserSignIn();

        SimpleDigitalClock clock1 = new SimpleDigitalClock();
        frame.add(clock1, BorderLayout.SOUTH);

        // Pack
        frame.pack();

        // Set origional focus on User Name text field
        txtUserName.requestFocusInWindow();

        // Make Visible
        frame.setVisible(true);
    }

    static class SimpleDigitalClock extends JPanel {
        String stringTime;
        int hour, minute, second;
        String aHour = "";
        String bMinute = "";
        String cSecond = "";

        public void setStringTime(String abc) {
            this.stringTime = abc;
        }

        public int Number(int a, int b) {
            return (a <= b) ? a : b;
        }

        SimpleDigitalClock() {
            Timer t = new Timer(1000, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    repaint();
                }
            });
            t.start();
        }

        @Override
        public void paintComponent(Graphics v) {
            super.paintComponent(v);
            Calendar rite = Calendar.getInstance();
            hour = rite.get(Calendar.HOUR_OF_DAY);
            minute = rite.get(Calendar.MINUTE);
            second = rite.get(Calendar.SECOND);
            if (hour < 10) {
                this.aHour = "0";
            }
            if (hour >= 10) {
                this.aHour = "";
            }
            if (minute < 10) {
                this.bMinute = "0";
            }
            if (minute >= 10) {
                this.bMinute = "";
            }
            if (second < 10) {
                this.cSecond = "0";
            }
            if (second >= 10) {
                this.cSecond = "";
            }
            setStringTime(aHour + hour + ":" + bMinute + minute + ":" + cSecond
                    + second);
            v.setColor(Color.RED);
            int length = Number(this.getWidth(), this.getHeight());
            Font Font1 = new Font("Digital", Font.BOLD, length / 5);
            v.setFont(Font1);
            v.drawString(stringTime, (int) length / 6, length / 2);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }
    }

    public UserSignIn() {
        initGUI();

    }

    public void initGUI() {

        setTitle("Login");

        JPanel pnlUserSignIn = new JPanel(new GridBagLayout());
        this.getContentPane().add(pnlUserSignIn);

        // build table for employees signed in
        JTable t = new JTable(null);

        JLabel label = new JLabel("Employees Currently Signed In");

        // ROW 1 BUTTONS
        // Username and Sign In buttons
        lblUserName = new JLabel("Username: ");
        txtUserName = new JTextField("Username");

        // Actions
        // txtUserName.addMouseListener(this);

        // Adding objects to Panel
        JPanel pnlLogin = new JPanel();
        pnlLogin.add(lblUserName);
        pnlLogin.add(txtUserName);

        // ROW 2 BUTTONS
        // Password and Cancel
        btnSignIn = new JButton("Sign In");
        btnCancel = new JButton("Cancel");

        // Actions
        btnSignIn.addActionListener(this);
        btnCancel.addActionListener(this);

        // Adding objects to Panel
        JPanel pnlPassword = new JPanel();
        pnlPassword.add(btnSignIn);
        pnlPassword.add(btnCancel);

        JPanel detailsPanel = new JPanel();
        detailsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        GridBagConstraints gbc = new GridBagConstraints();

        // Putting Objects into the grid
        gbc.gridx = 0;
        gbc.gridy = 0;

        pnlUserSignIn.add(label, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        pnlUserSignIn.add(new JScrollPane(t), gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        pnlUserSignIn.add(pnlLogin, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        pnlUserSignIn.add(pnlPassword, gbc);

        // gbc.gridx = 1;
        // gbc.gridy = 1;
        // gbc.gridwidth = 1;
        // gbc.gridheight = 2;
        // panel.add(detailsPanel, gbc);

        this.pack();

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if (actionEvent.getSource() == btnCancel) {
            System.exit(0);
        }
        // if(actionEvent.getSource()==txtUserName)
        // {
        // txtUserName.setText("");
        // txtUserName.requestFocus();
        // }
    }
}