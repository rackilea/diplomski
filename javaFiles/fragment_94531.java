try
    {
        combo.removeAllItems();
        conn = Operations.SqlConnector();
        String sql = "select EmpID, EmpName from Emp";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        ComboItem nullValue = new ComboItem(0,"- select -");
        combo.addItem(nullValue);
        while(rs.next())
        {
            int index = Integer.parseInt(rs.getString("EmpID"));
            String name = rs.getString("EmpName");
            ComboItem c = new ComboItem(index,name);
            combo.addItem(c);
            c.GetName();
        }
        pst.close();
        rs.close();
    }
    catch(SQLException | NumberFormatException e)
    {
        JOptionPane.showMessageDialog(null, e);
    }