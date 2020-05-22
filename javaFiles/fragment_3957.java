//inside onclick function
if(!confirm_pass.equals(password)){
    JOptionPane.showMessageDialog(null, "Passwords do not match", "Login Error", 
    JOptionPane.ERROR_MESSAGE);
    return; //the return keyword will stop the method to go further.
}


dispose();