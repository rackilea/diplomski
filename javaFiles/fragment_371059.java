btnSubmit.addActionListener(new ActionListener()
    {
public void actionPerformed(ActionEvent e)
{
    String enteredUsername = usernameField.getText();
    String query = "SELECT username, password FROM adminData WHERE username='"+enteredUsername+"'";
    String username = null;
    String password = null;
    ;
    try
    {
        rs = st.executeQuery(query);
        String fieldWarning = "*all field are mandatory!";

        @SuppressWarnings("deprecation") String enteredPassword = passwordField.getText();

        usernameField.setCursor(null);
        fieldLabel.setText("");

        int userLen = enteredUsername.length();
        int passLen = enteredPassword.length();

        if (userLen != 0 && passLen != 0)
        {
            if (userLen <= 32 && passLen <= 32)
            {
                while (rs.next())
                {
                    username = rs.getString("username");
                    password = rs.getString("password");
                    if (enteredUsername.equals(username))
                    {
                        if (enteredPassword.contentEquals(password))
                        {
                            AdminDashboard frame = new AdminDashboard();
                            frame.setVisible(true);
                            frame.dispose();
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Password Missmatch");
                        }

                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Invalid User");
                        passwordField.setText("");
                        usernameField.setText("");
                        usernameField.setCursor(null);

                    }
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null,
                    "Please enter a valid username or password! \n(Note: Only 32 char MAX)");
                passwordField.setText("");
                usernameField.setText("");
            }
        }
        else
        {
            fieldLabel.setText(fieldWarning);
            usernameField.setCursor(null);
        }
    }
    catch (SQLException e1)
    {
        JOptionPane.showMessageDialog(null, "Database Error: " + e1);
    }
}
    });