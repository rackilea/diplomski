if (rs != null) {
  do{
    sqlString = new StringBuffer();

    for (int i = 1; i <= columnCount; i++) {
        Object obj = rs.getObject(i);

        if (obj == null) {
            sqlString.append("null");
            sqlString.append(",");
        }
        else
        {
            int sqlTypes = rsmd.getColumnType(i);

            switch (sqlTypes) {
                case Types.VARCHAR:
                    sqlString.append("\"");
                    if (obj != null)
                        sqlString.append(rs.getString(i));

                    sqlString.append("\"");
                    sqlString.append(",");
                    break;
                case Types.NULL:
                    sqlString.append("null");
                    sqlString.append(",");
                    break;
                case Types.CHAR:
                    sqlString.append("\"");
                    if (obj != null)
                        sqlString.append(rs.getString(i));

                    sqlString.append("\"");
                    sqlString.append(",");
                    break;
                case Types.TIMESTAMP:
                    sqlString.append("\"");
                    if (obj != null)
                        sqlString.append(rs.getTimestamp(i));

                    sqlString.append("\"");
                    sqlString.append(",");
                    break;
                case Types.DOUBLE:
                    if (obj != null)
                        sqlString.append(rs.getDouble(i));

                    sqlString.append(",");
                    break;
                case Types.INTEGER:
                    if (obj != null)
                        sqlString.append(rs.getInt(i));

                    sqlString.append(",");
                    break;
                case Types.SMALLINT:
                    if (obj != null)
                        sqlString.append(rs.getInt(i));

                    sqlString.append(",");
                    break;
                case Types.DECIMAL:
                    if (obj != null)
                        sqlString.append(rs.getBigDecimal(i));

                    sqlString.append(",");
                    break;

                /*default:
                    if (obj != null)
                        sqlString.append(obj.toString());

                    sqlString.append(",");
                    break;*/
            }
        }while (rs.next());
    }