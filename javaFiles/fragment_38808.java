Vector<Vector<Object>> data = new  Vector<Vector<Object>>();

    while(rs.next()) {

        Vector<Object> row = new Vector<Object>();

        row.add(rs.getString("description"));
        row.add(rs.getString("amount")); 
        row.add(rs.getString("remarks")); 
        row.add(rs.getString("date"));


        data.add(row); // add each result/row to data Vector

    } // loop

    dtm.setDataVector(data , header); // load all the table rows to DefaultTableModel