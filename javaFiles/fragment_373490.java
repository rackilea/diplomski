CallableStatement cstmt;
ResultSet rs;
int i;
...
cstmt.execute();                            // Call the stored procedure 

while (cstmt.getMoreResults()){             // If we have more Results

    rs = cstmt.getResultSet();              // Get the result set

    while (rs.next()) {                     
        i = rs.getInt(1);                      
        System.out.println("Value from result set = " + i);  

    }
}

rs.close();
cstmt.close();