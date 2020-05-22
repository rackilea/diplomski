while(rs.next())
    {
        row = new Vector(columnsNumber);

        for(int i=1; i<=columnsNumber; i++)
        {
            // adding the rows in "row vector"
            InputStream binaryStream = rs.getBinaryStream(i);
            row.add(rs.getString(i));
            row.add(rs.getBinaryStream(8));
        }
        // adding the rows in the database
        rowdata.add(row);
    }