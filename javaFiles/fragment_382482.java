boolean found = false;
for (int i = 0; i < userList.size() && !found; i++) {
    if (userList.get(i).getUserID().equals(txtUserID.getText()) && userList.get(i).getPassword().equals(ptxtPassword.getText())) {
        found = true;
        if (userList.get(i).getUserType().equals("Administrator")) {
            System.out.println("Welcome Admin " + userList.get(i).getName() + " (" + userList.get(i).getUserID() + ")");
            mainMenuForm.lblUser.setText("Welcome Admin " + userList.get(i).getName() + " (" + userList.get(i).getUserID() + ")");

            mainMenuForm.setVisible(true);

            this.setVisible(false);

        } else if (userList.get(i).getUserType().equals("Sales Manager")) {
            System.out.println("Welcome SM" + userList.get(i).getName());
            mainMenuForm.lblUser.setText("Welcome SM " + userList.get(i).getName() + " (" + userList.get(i).getUserID() + ")");

            mainMenuForm.setVisible(true);
            mainMenuForm.lblRegistration.hide();

            this.setVisible(false);

        } else if (userList.get(i).getUserType().equals("Purchase Manager")) {
            System.out.println("Welcome PM" + userList.get(i).getName());
            mainMenuForm.lblUser.setText("Welcome PM " + userList.get(i).getName() + " (" + userList.get(i).getUserID() + ")");

            mainMenuForm.setVisible(true);
            mainMenuForm.lblDailySales.hide();

            this.setVisible(false);
        }
    }
}

// if we didn't find the user/password combination, display the error message
if(!found) {
    JOptionPane.showMessageDialog(null, "Invalid User ID or Password!", "Login Error", JOptionPane.OK_OPTION);
}