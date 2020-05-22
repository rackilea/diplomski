try{
           Class.forName("oracle.jdbc.OracleDriver");
           Connection conn;
           PreparedStatement pstmnt;
       try (conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","123"))
 {

        pstmnt = conn.prepareStatement("delete from TEMP where MATRICRN=?");
        String roll=matricRoll.getText();
        int rollm=Integer.valueOf(roll);

        pstmnt.setInt(1, rollm);
        pstmnt.executeUpdate();
        JOptionPane.showMessageDialog(null,"Deleted");
            conn.close();
            pstmnt.close();
            GI.setVisible(true);
            ED.setVisible(false);
            addingToFrame();
            settingBounds();  
                } 
    catch (SQLException ex) 
            {JOptionPane.showMessageDialog(null,"error"+ex);}

       } 
    catch (ClassNotFoundException exe) {
                 JOptionPane.showMessageDialog(null,exe);    }