if (e.getSource().equals(btn_cancel)) {
    System.exit(0);
} else if (e.getSource().equals(Btn)) {
    if (tf_Fname.getText().trim().length() == 0 && tf_Lname.getPassword().length == 0) {
        JOptionPane.showMessageDialog(null, "Text Fields cannot be blank! ", "Blank", JOptionPane.WARNING_MESSAGE);
    } else {
        try {
            selectfromdb();
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } finally {
        }
    }
} else if (e.getSource().equals(btn_Newuser)) {
    System.out.println("You have clicked on" + btn_Newuser);
    new Newuser();
}