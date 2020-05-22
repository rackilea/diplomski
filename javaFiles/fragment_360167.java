CachedRowSet rs;
.......................
.......................
Integer id;
String name;

while (rs.next())
{               
     if (rs.getInt("id") == 13)
     {
          id   = rs.getInt("id");
          name = rs.getString("name")); 
     }              
}