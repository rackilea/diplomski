Calendar calendar = Calendar.getInstance();
    Timestamp ourJavaDateObject = new Timestamp(calendar.getTime().getTime());

    String sql= "INSERT INTO info_history(c_id,name,middlename,lastname,contact,age,"
        + "address,checkt_in,date)VALUES(?,?,?,?,?,?,?,?,?)";
    String sqls = "UPDATE info SET stud = '1' WHERE id = ? ORDER BY id DESC";
    try (PreparedStatement pst = cn.prepareStatement(sql);
                PreparedStatement psts = cn.prepareStatement(sqls)) {
        psts.setInt(1, Integer.parseInt(idno.getText()));      
        psts.executeUpdate();

        pst.setString(1, idno.getText());      
        pst.setString(2, name5.getText());
        pst.setString(3, middlename5.getText());
        pst.setString(4, lastname5.getText()); 
        pst.setString(5, contact5.getText());
        pst.setString(6, age5.getText());
        pst.setString(7, address5.getText());
        pst.setString(8, time.getText());    
        pst.setTimestamp(9, ourJavaDateObject);
        pst.executeUpdate();

        JOptionPane.showMessageDialog(null, "", "SAVED!", JOptionPane.INFORMATION_MESSAGE);
        info();           
    } catch(Exception e) {
        JOptionPane.showMessageDialog(null, "INFO NOT SAVED!", e.getLocalizedMessage(),
                JOptionPane.INFORMATION_MESSAGE);
    }