private void confirmActionPerformed(java.awt.event.ActionEvent evt) {
    //  String f= "jdbc:derby://localhost:1527/BStest";
    String name = username.getText().trim();
    String gender = null;
    String passw = String.valueOf(pass.getPassword());
    String repassw = String.valueOf(repass.getPassword());
    String phone2 = phone.getText().trim();
    String emaill = email.getText().trim();

    // NAME
    //is Name text field empty 
    if (name.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Add a username!");
        username.requestFocus();
        return;
    }

    // PASSWORD
    //is Password field empty 
    if (passw.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Add a Password!");
        pass.requestFocus();
        return;
    }
    /* A Regular Expression is used here to ensure your desired
       password rules apply - Minimum of 8 characters in length,
       at least 1 Uppercase Letter, at least 1 Lowercase letter, 
       at least 1 digit.   */
    if (!passw.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$")) {
        JOptionPane.showMessageDialog(null, "Password must be:\n\n"
                + "- At least 8 characters in length,\n"
                + "- Contain at least 1 Uppercase letter,\n"
                + "- Contain at least 1 Lowercase letter,\n"
                + "- Contain at least 1 number.");
        pass.requestFocus();
        return;
    }
    // confirmed password is the same for password
    if (!repassw.equals(passw)) {
        JOptionPane.showMessageDialog(null, "Type password Again!");
        repass.requestFocus();
        return;
    }

    // PHONE
    //is phone text field empty 
    if (phone2.isEmpty()) {//is text field empty 
        JOptionPane.showMessageDialog(null, "Add Phone number !");
        phone.requestFocus();
        return;
    }
    // starts with 05
    String zereofive = phone2.substring(0, 2);
    // check length of phone number 
    if (phone2.length() != 10 && !zereofive.equals("05")) {
        JOptionPane.showMessageDialog(null, "enter 10 digits for the phone number and starts with 05");
        phone.requestFocus();
        return;
    }

    // E-MAIL
    //is E-Mail text field empty
    if (emaill.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Add email please !");
        email.requestFocus();
        return;
    }
    // E-Mail
    char c, c2 = emaill.charAt(0);
    String bfat = emaill.substring(0, emaill.indexOf("@"));//digits berfore @
    String domain = emaill.substring(emaill.indexOf("@") + 1);//check domain
    // is first char off email a letter
    if (!Character.isLetter(c2)) {
        JOptionPane.showMessageDialog(null, "Emails can only start with letters!");
        email.requestFocus();
        return;
    }
    //check digits before @
    if (bfat.length() < 6 || bfat.length() > 15) {
        JOptionPane.showMessageDialog(null, "Invalid digits in Email address!");
        email.requestFocus();
        return;
    }
    //check domain of email
    if (!domain.equals("gmail.com") && !domain.equals("hotmail.com")) {
        JOptionPane.showMessageDialog(null, "Email domain is wrong!");
        email.requestFocus();
        return;
    }

    // GENDER
    //no gender selected
    if (!m.isSelected() && !female.isSelected()) {
        JOptionPane.showMessageDialog(null, "Choose a Gender!!");
        return;
    }
    //both Genders are selected where it shoud be only one
    else if (m.isSelected() && female.isSelected()) {
        JOptionPane.showMessageDialog(null, "Select only One Gender!!");
        return;
    }
    // is female or male selected
    if (m.isSelected()) {
        gender = "Male";
    }
    else if (female.isSelected()) {
        gender = "Female";
    }

    // AGE
    //is Age text field empty
    String theAge = age.trim().getText();
    if (theAge.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Enter your age !!");
        age.requestFocus();
        return;
    }
    int agee = 0;    // Default
    // Regular Expression used to ensure a Integer 
    // Numerical String value was supplied.
    if (theAge.matches("\\d+")) {
        agee = Integer.parseInt(theAge);
    }
    // only 18 + can register
    if (agee < 18) {
        JOptionPane.showMessageDialog(null, "You can't register because you are under 18!");
        age.requestFocus();
        return;
    }

    // DATABASE
    Connection connection = null;
    PreparedStatement reg, exist;
    ResultSet rs = null;
    String query = "INSERT INTO customer (Cu_name, Cu_password, Cu_age, Cu_gender, Cu_email, Cu_phone) VALUES (?, ?, ?, ?, ?, ?)";//enter user info in database
    String record_exists = "SELECT * FROM customer where Cu_name=? and Cu_password= ? and Cu_age=? and Cu_gender=? and Cu_email=? and Cu_phone=?";
    try {
        String f = "jdbc:derby://localhost:1527/BStest";
        connection = DriverManager.getConnection(f, "meme", "Moudhi102");
        reg = connection.prepareStatement(query);
        exist = connection.prepareStatement(record_exists);
        reg.setString(1, name);
        reg.setString(2, passw);
        reg.setInt(3, agee);
        reg.setString(4, gender);
        reg.setString(5, emaill);
        reg.setString(6, phone2);

        exist.setString(1, name);
        exist.setString(2, passw);
        exist.setInt(3, agee);
        exist.setString(4, gender);
        exist.setString(5, emaill);
        exist.setString(6, phone2);
        rs = exist.executeQuery();

        if (rs == null) {
            reg.executeUpdate();
            JOptionPane.showMessageDialog(null, "Complete! new user added !! ");
        }
        // User Already Exists In Database
        else {
            JOptionPane.showMessageDialog(null, "User already exists");
        }
    }
    catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, ex);
    }
    finally {
        if (reg != null) {
            reg.close();
        }
        if (rs != null) {
            rs.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

}