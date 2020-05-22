boolean loopEntered = false;
      while (rs1.next())
      {
                loopEntered = true;
                String pid = rs1.getString("pid");
                System.out.println(pid);
                String pd = rs1.getString("description");
                double price = rs1.getDouble("price");

              %>
                 <br>
                 Product id : <%=pid %><br>
                 Description : <%=pd %><br>
                 Price : <%=price %>
              <%
      }

      if(!loopEntered)
      // print your error messages.