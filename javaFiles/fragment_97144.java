//Creating ResultSet
ResultSet rs = stmt.executeQuery(sql);

//Displaying database
System.out.println("Displaying records before doing some operations");

if (rs.next()) {        
    System.out.println(rs.getInt(1) + " "
        + rs.getString(2) + " " + rs.getString(3));
}