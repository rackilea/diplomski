StringJoiner col = new StringJoiner(",");
 StringJoiner val = new StringJoiner(",");
 //First Iteration: Create the Statement
 for(String c : columns) {
   //Your PDF has a matching formfield 
   if(pdf.hasKey(c)) {
     col.add(c);
     val.add("?");
   }
 }
 String sql = String.format("INSERT INTO table (%s) VALUES (%s)", col.toString(), val.toString());
 try(PreparedStatement insert = con.prepareStatement(sql)) {
   //Insert position in statement
   int pos = 0;
   //Second iterations: Bind the values to the statement
   for(String c : columns) {
     //Your PDF has a matching formfield 
     if(pdf.hasKey(c)) {
       insert.setString(++pos, pdf.get(c));
     }
   }
   insert.executeUpdate();
 } catch (SQLException e) {
        e.printStackTrace();
 }