while(rs.next())
{
    for (int i = 1; i <= numColumns; i++)
    {
        back.append("<tr><td>" + rsmd.getColumnName(i) +
                    "</td>" + "<td>" + rs.getString(i) + "</trd</tr>");
    }
}