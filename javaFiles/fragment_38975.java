//Construct a statement
String yourStatement = "Select COLUMN_B from aTable WHERE COLUMN_A LIKE 'A'" // EDITED
PreparedStatement aPrepStatement = null;
ResultSet rs = null;
List<String> aList = new ArrayList<String>(); // ADDED
try
{
   aPrepStatement = yourConnection.prepareStatement(yourStatement)
   rs = aPrepStatement.executeQuery();
   while(rs.next())
   {
       // You are now in the first row of data depending on your query
       // String column1 = rs.getString(1);   // 'A' In the table you descrbed above (for first iteration
       String column2 = rs.getString(1);   // 'X' In the table you descrbed above
       // Now do what you need to with the data
       aList.add(column2)  // EDITED

   }
 }
 catch (Exception ex) {
      // deal with any exceptions that arise
      ex.printStackTrace();
 }
 finally
{
    //Close your Resultset and prepared statement (this will possibly need a try catch block also
    if(rs != null)
        rs.close();
    if(aPrepStatement != null)
        aPrepStatement.close();
}
// ADDED BELOW
for(String s: aList)
    System.out.println(s) // should give output
                          // X
                          // Y
                          // Z