public static void main(String[] args) {
    int p = JOptionPane.showConfirmDialog(null, "Are you sure to add this staff?", "Comfirmation", JOptionPane.YES_NO_OPTION);

    if (p == 0) {
        if (staffID.getText().trim().isEmpty()) {// validate user input
            JOptionPane.showMessageDialog(null, "Please enter staff ID"); // remind user
        } else if (staffName.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter staff name");
        } else if (staffPassword.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter password");
        } else if (staffTel.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter staff telephone");
        } else {
            String sql = "Insert into login.createstaff (Staff_ID,Staff_Name,Staff_password,Staff_Tel,Staff_position,image) values (?,?,?,?,?,?)";
            try {
                pst = conn.prepareStatement(sql);
                pst.setString(1, staffID.getText());
                pst.setString(2, staffName.getText());
                pst.setString(3, staffPassword.getText());
                pst.setString(4, staffTel.getText());
                String value = staffPosition.getSelectedItem().toString();
                pst.setString(5, value);

                pst.setBytes(6, person_image);


                pst.execute();
                JOptionPane.showMessageDialog(null, "New Staff Added");


            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
}