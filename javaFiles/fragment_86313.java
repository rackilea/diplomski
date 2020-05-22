<% // dbconnection
          try {
                   Class.forName("com.mysql.jdbc.Driver");
                 java.sql.Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
                  Statement statement = conn.createStatement() ;
       resultSet=statement.executeQuery("select * from product") ; 
                %> 
    <!--this loop will get all images-->
       <% while(resultSet.next()){ %> 
    <!--I'm using id column of table,you can use any coulmn which is unique to all row-->
   Image - <img src="./Serv1?id=<%=resultSet.getString("id")%>" width="20%"/>
  < p>Product <%=r.getInt(1)%>: <%=r.getString(2)%></p>

    <% 
    }
    }catch(Exception e){}

    %>