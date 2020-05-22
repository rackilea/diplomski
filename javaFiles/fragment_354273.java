public class TestUpdate {


  public static void main(String[] args) throws ClassNotFoundException, SQLException{
      TestsJdbc jdbc= new TestsJdbc();
      jdbc.connect();
      Connection con =jdbc.getConnection();
      List<java.sql.Timestamp> listIssueDate=getIssueDate(con );
      updateReturnDate(con, listIssueDate);
      jdbc.closeConnexion();

     }




  public static java.util.Date tmsToUtilDate(java.sql.Timestamp timestamp) {
        long milliseconds = timestamp.getTime() + (timestamp.getNanos() / 1000000);
        return new java.util.Date(milliseconds);
    }

  public static  java.sql.Timestamp getTimestamp(java.util.Date date){
      return date == null ? null : new java.sql.Timestamp(date.getTime());
    }




   public static java.util.Date addDay(java.util.Date curDate, int nbDay){
       Calendar cal = Calendar.getInstance();
       cal.setTime(curDate);
       cal.add(Calendar.DATE, nbDay); // add 10 days

       return cal.getTime();
   }




   public static List<java.sql.Timestamp>  getIssueDate(Connection connexion) throws SQLException{
    String  query="SELECT issueTime from issue";
    Statement statement;
    List<java.sql.Timestamp> listDate= new ArrayList<java.sql.Timestamp>();
        try {
            statement = (Statement) connexion.createStatement();
            ResultSet rs = statement.executeQuery( query);
            while (rs.next()) {

                //java.sql.Time dbSqlTime = rs.getTime("issueTime");//only time
                //java.sql.Date dbSqlDate = rs.getDate("issueTime");//Date ex :YYYY-MM-DD
                java.sql.Timestamp dbSqlTimestamp = rs.getTimestamp("issueTime");// timestamp Date ex :YYYY-MM-DD hh:mm:ss
                System.out.println("date:"+dbSqlTimestamp);
                System.out.println();
                listDate.add(dbSqlTimestamp);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

       return listDate;
   }

     public static void updateReturnDate(Connection connexion, List<java.sql.Timestamp> listIssueDate) throws SQLException
      {

          for(java.sql.Timestamp sqlIssueDate:listIssueDate){

              // 
              java.util.Date tempUtilDate=tmsToUtilDate(sqlIssueDate);
              java.util.Date newutilDate=addDay(tempUtilDate, 14);
              java.sql.Timestamp returnDate=getTimestamp(newutilDate);



              System.out.println(returnDate.getTime());
              System.out.println(sqlIssueDate);
             //Test
             String query="UPDATE issue SET return_date=? WHERE issueTime = ?";


              PreparedStatement preparedStmt = connexion.prepareStatement(query);
              preparedStmt.setTimestamp(1, returnDate);
              preparedStmt.setTimestamp(2, sqlIssueDate);

              // execute the java preparedstatement
              preparedStmt.executeUpdate();

          }
              //connexion.close();

      }
}