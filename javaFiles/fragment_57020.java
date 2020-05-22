JFrame frame = new JFrame("LoginExample");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

// fill the JFrame with the main GUI
// .... 

frame.pack();

// create the LoginPanel JPanel here
LoginPanel loginPanel = new LoginPanel();

// and display it in a JOptionPane here
int result = JOptionPane.showConfirmDialog(frame, loginPanel, 
        "User Log-In", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
if (result == JOptionPane.OK_OPTION) {
    String userName = loginPanel.getUserName();
    char[] password = loginPanel.getPassword();

    // test to make sure code is working
    System.out.println("User Name: " + userName);

    // check for name/password validity here
    // ... if name/password OK, then show JFrame:
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
}