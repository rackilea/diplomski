int i=0;
while (rs.next()) 
{
     int type=rs.getMetaData().getColumnTypeName(i);
     if(type ==Types.INTEGER)
       value = (T) rs.getInt();
     else if(type ==Types.DOUBLE)
       value = (T) rs.getDouble();
     else if(type ==Types.FLOAT)
       value = (T) rs.getFloat();
     else if(type ==Types.VARCHAR)
       value = (T) rs.getString();
     else if(type ==Types.LONG)
       value = (T) rs.getLong();
}