public String[] doQuery (String query, String columnName) //columnName not needed if you know the index of the column or if the name is always the same, in which case it could be some constant
{
  List<String> v = new ArrayList<String>();

  try {
     Statement stmt = con.createStatement();    
     ResultSet rs = stmt.executeQuery(query);           

     while(rs.next()) {    
        v.add( rs.getString(columnName) ); //or rs.getString(1); if you know the column is the first in the query's result
     }
     rs.close();     
     stmt.close();   
  } catch (Exception e) { e.printStackTrace(); }

  return v.toArray(new String[v.size()]); 
}