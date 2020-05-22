try (
        Connection con = DriverManager.getConnection("jdbc:odbc:Dalvi");
        PreparedStatement ps = con.prepareStatement("UPDATE customer_details SET customer_id = ?, customer_name = ? , customer_contact =?  WHERE customer_id = ?");
    )
{
    ps.setInt(1, Integer.parseInt(textFieldId.getText()));    
    ps.setString(2,textFieldId1.getText());
    ps.setString(3,textFieldId2.getText());
    ps.setInt(4, Integer.parseInt(textFieldId3.getText()));
    ps.executeUpdate();
}
catch (SQLException s) 
{
    System.out.println("SQL code does not execute.");
    JOptionPane.showMessageDialog(null,"Please Enter the Detail Correctly");
}
    catch (NumberFormatException e)
    {
    }