while (rs.next())
        {
            row = new ArrayList();

            for (int column = 1; column <= rm.getColumnCount(); column++) {
                row.add(rs.getObject(column));
            }

            result.add(row);
        }