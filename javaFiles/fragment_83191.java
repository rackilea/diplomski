<%
    String value = request.getParameter("Meter_No");
    int v=Integer.parseInt(value);
    Connection conn = null;
    PreparedStatement pst = null;
    try{

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDirver");
        conn = DriverManager.getConnection ("jdbc:sqlserver://localhost:1433;databaseName=myDatabase;user=shakir;password=shakir123");
        pst = conn.prepareStatement("delete from qesco_table where Meter_No = ?");
        pst.setInt(1,v);

        pst.executeUpdate();
      }catch(Exception e){
        System.out.print(e.getMessage());
    }finally{
        pst.close();
        conn.close();
    }
%>