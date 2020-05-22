public void selectedRow() throws SQLException{
        String values = 
        String.valueOf(studentTable.getSelectionModel().getSelectedItem());
        String row = values.toString().split(",")[0].substring(1);
        String sql = "select * from student where id= '" + row + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                String add1 = rs.getString("school_name");
                System.out.println("The selected row is ==> "+ add1);
            }
    }