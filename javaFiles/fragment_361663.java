ResultSet rs = ps.executeQuery("select ItemCode, ItemName, ItemDescription, Rate from payroll_system.payroll_items"); 
while (rs.next()) {
                 out.println("<tr>");
                 out.println("<td>"+ rs.getString("ItemCode")+"</td>");
                 out.println("<td>"+ rs.getString("ItemName")+"</td>");
                 out.println("<td>"+ rs.getString("ItemDescription")+"</td>");
                 out.println("<td>"+ rs.getString("Rate")+"</td>");
                 out.println("</tr>");
}