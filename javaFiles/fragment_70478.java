String query = request.getParameter("query");
if(query!=null && !"".equals(query))
{
        Connection con = new DBConnection().getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        ResultSetMetaData rsmd = rs.getMetaData();
        int  totalColumn = rsmd.getColumnCount();


        out.println("<table border='1' style='border-collapse:collapse'>");
        out.println("<tr>");

        for(int i=1;i<=totalColumn;i++)
        {
            String columnName = rsmd.getColumnName(i);
            out.println("<th>"+columnName+"</th>");
        }
        out.println("</tr>");

        while(rs.next())
        {    
            out.println("<tr>");
            for(int col=1;col<=totalColumn;col++)
            {            
                Object obj= rs.getObject(col);                    
                out.println("<td>"+ String.valueOf(obj) +"</td>");
            } 
            out.println("</tr>");
        }
        out.println("</table>");
}