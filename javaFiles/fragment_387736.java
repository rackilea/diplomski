boolean loggedIn = false;

while(rs2.next()) {
    if((user.equals(uname)) && (pwd.equals(password))){
        loggedIn = true;
        break;
    }
}

if (!loggedIn) {
    JOptionPane.showMessageDialog(this, "Incorrect Username or Password!", "Login Error", JOptionPane.ERROR_MESSAGE);
}