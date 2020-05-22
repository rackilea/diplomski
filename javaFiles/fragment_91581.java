try {
 String query = "Select * from plants where name = ?";
 sttmnt.setString(1, name);
 String plantName = "";
 ResultSet rs = sttmnt.executeQuery(query);

 StringBuffer output = new StringBuffer(); 
 while (rs.next()) { // display information for each plant.
    plantName = rs.getString(2);  // display fields in cells
    output.append("<tr><td>");
    output.append(plantName + "</td><td>");
    output.append(rs.getString(3) + "</td><td>");
    output.append("$" + rs.getString(5) + "</td><td>");
    output.append(rs.getString(4) + "</td>");
    output.append("<input type=\"hidden\" name=\"plantName" +
     plantNo + "\" value=\"" + plantName + "\">");
    output.append("<input type=\"hidden\" name=\"plantID" +
     plantNo + "\" value=\"" + rs.getString(1) + "\">");
    output.append("</tr>");
    plantNo++;
 }
 if (plantNo == 0) output.append("<tr><td align=\"center\" " +
      " colspan=\"4\">Sorry, there are currently no " + name
      + " plants for sale.</td></tr>");
 else
     output.append("<tr><td align=\"center\" " +
             " colspan=\"4\">Showing " + plantNo
             + " results. </td></tr>");

 output.append("</table>");
 out.println(output.toString());
 rs.close();
}