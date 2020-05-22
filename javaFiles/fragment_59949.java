//prepare a statement -- omitting the non geometry values from OP question for clarity
String sql = "Insert into modul (geom) values (ST_MakePoint(?, ?))";
PreparedStatement stmt = conn.prepareStatement(sql);
//add the actual x and y values
stmt.setFloat(1, x);
stmt.setFloat(2, y);
stmt.executeUpdate();