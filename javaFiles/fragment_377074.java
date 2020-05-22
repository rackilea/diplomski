<%
            PreparedStatement ps=con.prepareStatement("select * from artist");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){ %>
            <table><tr><th>artist fast name:</th><td><%=rs.getString(1) %></td></tr> 
                <tr><th>artist middle name:</th><td><%=rs.getString(2) %></td></tr>
                <tr><th>artist last name</th><td><%=rs.getString(3) %></td></tr>
                <tr><th>artist job</th><td><%=rs.getString(4) %></td></tr>
                <tr><th>artist image</th><td>
                <%
                Blob bl=rs.getBlob(5);
                byte[] image=bl.getBytes(1, (int)bl.length());
                %>
                <img src="data:image/jpeg;base64, <%=javax.xml.bind.DatatypeConverter.printBase64Binary(image)%>
            " height="100" width="100" alt="bye"/> </td></tr>
            </table> 
                <%
                }
                con.close();
          %>