// body_template, idno are of type String 
String sql_command = "Update email_template set body_template=? WHERE id=?";
PreparedStatement pst = con.prepareStatement( sql_command );
pst.setString( 1, body_template );
pst.setString( 2, idno );

int updateResult = pst.executeUpdate();