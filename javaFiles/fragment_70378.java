String sql = "Select * from ???";
    Statement stmt = connection.createStatement();
    ResultSet rs = stmt.executeQuery( sql );
    ResultSetMetaData md = rs.getMetaData();
    int columns = md.getColumnCount();

    //  Get column names

    for (int i = 1; i <= columns; i++)
    {
        columnNames.addElement( md.getColumnName(i) );
    }

    //  Get row data

    while (rs.next())
    {
        Vector<Object> row = new Vector<Object>(columns);

        for (int i = 1; i <= columns; i++)
        {
            row.addElement( rs.getObject(i) );
        }

        data.addElement( row );
    }

    //  Create table with database data

    DefaultTableModel model = new DefaultTableModel(data, columnNames)
    {
        @Override
        public Class getColumnClass(int column)
        {
            for (int row = 0; row < getRowCount(); row++)
            {
                Object o = getValueAt(row, column);

                if (o != null)
                {
                    return o.getClass();
                }
            }

            return Object.class;
        }
    };

    JTable table = new JTable( model );
    JScrollPane scrollPane = new JScrollPane( table );