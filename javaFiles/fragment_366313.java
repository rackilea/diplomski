try {
        //CBProv is the Combobox
        CBProv.removeAllItems();

        rs=Con.sqlQueryTable("Select id_prov, name_prov from prov");

        while(rs.next())
        {                
            String id = rs.getString("id_prov"); // Get the Id
            String name = rs.getString("name_prov"); // Get the Name

            ComboItem comboItem = new ComboItem(id, name); // Create a new ComboItem
            CBProv.addItem(comboItem); // Put it into the ComboBox

        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error" + e  );
    }