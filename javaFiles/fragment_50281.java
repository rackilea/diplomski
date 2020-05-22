Integer param1 = Integer.valueOf(jTextField2.getText());
Integer param2 = Integer.valueOf(jTextField1.getText());
Object param3 = jComboBox1.getSelectedItem();
Integer param4 = Integer.valueOf(jTextField3.getText());

String sql = "INSERT INTO carz VALUES (?, ?, ?, ?)";
PreparedStatement statement = CC.prepareStatement(sql);
statement.setInt(1, param1);
statement.setInt(2, param1);    
statement.setObject(3, param3);
statement.setInt(4, param4);

int result = statement.executeUpdate();