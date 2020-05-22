ResultSet rs;
Connection con = null;
public void fetchResultSet()
{

   try {
        if(con==null || con.isClosed())
        {
          Class.forName("sun.jdbc.odbc.JdbcOdbc");
          con = DriverManager.getConnection("jdbc:odbc:StockInventory","sa","123");           
        }
        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        String query = "select * from Stocktbl";
        rs = stmt.executeQuery(query); 
      }catch(Exception ex)
      {
         System.out.println(ex);
         Logger.getLogger(StockScr.class.getName()).log(Level.SEVERE, null, ex);

         try
         {
            if(con != null)
            {
              con.close();
            }
         }catch(Exception x){}
      }
}