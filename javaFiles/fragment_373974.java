protected void initComboBoxModel(final ComboBox cmp) {

    try {
        String sql = "SELECT * FROM stockinfo";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();

        Vector<String> vec = new Vector<String>(); // use generics 
        while (rs.next()) {
            String item = rs.getString("Parts");
            vec.addElement(item);            
        }

        cmp.setModel(new DefaultListModel(vec)); // here you set the model

    } catch (Exception ex) {
        Dialog.show("Error", "initComboBoxModel count not populate the combo box.", "OK", null);
    }
 }