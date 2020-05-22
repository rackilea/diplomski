<%
ResultSet rs = (ResultSet)request.getAttribute("display");

ResultSetMetaData rsmd = rs.getMetaData();
        int columnsNumber = rsmd.getColumnCount(); 

        while (rs.next()) {

          for(int i = 1 ; i <= columnsNumber; i++){
                out.print(rs.getString(i) + " " + "    " + "<br/>");
          }

            out.print("<br/>"); //Move to the next line to print the next row.  
            }
        }

    rs.close();
%>