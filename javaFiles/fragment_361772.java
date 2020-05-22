String email;
    Boolean validEmail = False;

    while(!validEmail)
    {
        //ask the user for the email
        email = JOptionPane.showInputDialog (null, "enter email");
        if (email.contains("@branfordschools.org")){                
            JOptionPane.showMessageDialog(null,"Password Accepted");
            validEmail = True;
        } else {
            JOptionPane.showMessageDialog(null,"Password Incorrect, Please Re-Enter Password");
        }
    }