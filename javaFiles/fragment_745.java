String sql = "UPDATE Page SET Title = ? WHERE Name = ?";

PreparedStatement stmt = connection.prepareStatement(sql);

stmt.setString( 1, textField1.getText() );
stmt.setString( 2, textField2.getText() );
stmt.executeUpdate();
stmt.close();