ResultSetMetaData rsmd = rs.getMetaData();
int columnsNumber = rsmd.getColumnCount();                     

// Iterate through the data in the result set and display it. 

while (rs.next()) {
//Print one row          
for(int i = 1 ; i <= columnsNumber; i++){

      System.out.print(rs.getString(i) + " "); //Print one element of a row

}

  System.out.println();//Move to the next line to print the next row.           

    }