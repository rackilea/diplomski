int rowsAffected = 
  stmt.executeUpdate( sql, Statement.RETURN_GENERATED_KEYS );  
ResultSet rs = stmt.getGeneratedKeys();  

//******************************************************  
// in case of batch insert, you can check how many are inserted
rs.last();  
int rows = rs.getRow();  
System.out.println( "Generated keys count: " + rows );  
//******************************************************/  

int currentRow = 1;  
rs.beforeFirst();  
while( rs.next() ) {  
    System.out.println( /**/( currentRow++ ) + " = " + /**/rs.getInt( 1 ) );  
} // while rs