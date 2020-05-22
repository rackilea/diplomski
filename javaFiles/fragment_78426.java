PreparedStatement st = con.prepareStatement("SELECT password FROM employee WHERE name = ?");
st.setString(1, nameTextField.getText().trim());
ResultSet rs = st.executeQuery();
if (rs.next() && rs.getString(1).equals(passwordTextField.getText()))
  Message.setText("Login Success");
else
  Message.setText("Failed");
rs.close();
con.close();