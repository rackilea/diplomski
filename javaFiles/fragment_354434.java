List<List> result = new ArrayList()<List>;
List col = new ArrayList();

ResultSet rs = (ResultSet)stmt.getObject(5);
ResultSetMetaData rsMetaData = rs.getMetaData();

        int numberOfColumns = rsMetaData.getColumnCount();
        while (rs.next()) 
        {
            col = new ArrayList();
            for(int j=1;j<numberOfColumns;j++)
                col.add(rs.getString(j);

            result.add(col);
        }