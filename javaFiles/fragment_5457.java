package test;

import java.sql.*;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Delete { // Class names should start with an upper case letter.
    private JFrame frame; // Don't use a static JFrame (only if you know
                          // exactly what you are doing :))
    private JButton showDialogButton; // This must be a field if you wanna access it in 
                                      // another class, in your case, the listener.

    public static void main(String[] args) {
        // Schedule this for the event dispatch thread (edt)
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Delete del = new Delete(); // Create new instance of Delete class.
                del.displayJFrame(); //Call display method.
            }
        });
    }

    private void displayJFrame() {
        frame = new JFrame("Our JButton listener example");

        // Create our JButton
        showDialogButton = new JButton("Click Me");

        // Add the listener to the JButton to handle the "pressed" event
        showDialogButton.addActionListener(new MyActionListener());

        // Adding the button should be done outside of the ActionLister. If it is inside
        // the frame it will never be shown, because the Listener cannot be called 
        // (obviously) without a visible frame.
        frame.getContentPane().setLayout(new FlowLayout());
        // Add the button to the frame
        frame.add(showDialogButton);

        // Set up the JFrame, then display it
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(300, 200));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // display/center the JDialog when the button is pressed

            try {
                Scanner scan = new Scanner(System.in);
                // System.out.println("Enter a table");
                String table = "teacherexample";
                // System.out.println("Enter a num");
                int num = 4;

                // Get connection to DB
                Connection myConn = DriverManager.getConnection("jdbc:mysql://LocalHost:3306/interndata?useSSL=false",
                        "root", "Starwars991211");
                String sql = ("DELETE FROM " + table + " ") + "WHERE EntryNumber = " + num;
                PreparedStatement preparedStatement = myConn.prepareStatement(sql);
                preparedStatement.executeUpdate(sql);

            } catch (Exception exc) {
                exc.printStackTrace();
            }
        }
    }
}