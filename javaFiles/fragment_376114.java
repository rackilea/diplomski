Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:webapps"); 
// END OF  DATABASE CONNECTION SET UP 
// START OF TESTING 

String mysql="select * from hotels";
Statement s=con.createStatement();
ResultSet rst=s.executeQuery(mysql);

out.println("<table border='1' width='70%'>");
out.println(" <tr>");
out.println(" <td width='10%'><b>Name of Place</b></td>");
out.println(" <td width='10%'><b>Country</b></td>");
out.println(" <td width='10%'><b>Price Per Night</b></td>");
out.println(" <td width='10%'><b>Maximum Persons</b></td>");
out.println(" <td width='10%'><b>Star Rating</b></td>");
out.println(" <td width='10%'><b>Description</b></td>");
out.println(" </tr>");

while (rst.next()) {

// Column Details of hotels

out.println(" <tr>");

out.println(" <td width='10%'>" + rst.getString ("NameofPlace") + "</td>");
out.println(" <td width='10%'>" + rst.getString ("Country") + "</td>");
out.println(" <td width='10%'>" + rst.getString ("PricePerNight") + "</td>");
out.println(" <td width='10%'>" + rst.getString ("MaximumPersons") + "</td>");
out.println(" <td width='10%'>" + rst.getString ("StarRating") + "</td>");
out.println(" <td width='20%'>" + rst.getString ("Description") + "</td>");
out.println(" </tr>");
}

out.println("</table>");


rst.close();
con.close();