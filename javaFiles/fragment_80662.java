DefaultTableModel resultSetToTableModel(
     DefaultTableModel model,
     ResultSet row) throws SQLException
    {
    ResultSetMetaData meta= row.getMetaData();
    if(model==null) model= new DefaultTableModel();
    String cols[]=new String[meta.getColumnCount()];
    for(int i=0;i< cols.length;++i)
        {
        cols[i]= meta.getColumnLabel(i+1);
        }

    model.setColumnIdentifiers(cols);

    while(row.next())
        {
        Object data[]= new Object[cols.length];
        for(int i=0;i< data.length;++i)
             {
             data[i]=row.getObject(i+1);
             }
        model.addRow(data);
        }
    return model;
    }