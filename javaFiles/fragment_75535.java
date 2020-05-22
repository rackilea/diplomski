ResultSet rs = statement.executeQuery(yourSQLQueryString); // Get your ResultSet from Database

rs.last();                  // Place the record pointer onto the last row
int counter = res.getRow(); // Get the row number (there's your count)
rs.first();                 // Place the record pointer onto the first row for the while loop
String[] myArray = new String[counter]; // Declare and Initialize your array

counter = 0; // Reset counter to 0 so as to act as a Index incrementer
// Iterate through the ResultSet and fill Array
while (rs.next()) {
    myArray[counter] = rs.getString(columnNumber_OR_ColumnNameString); 
    counter++;
}

// See what's in Array...
for (int i = 0; i < myArray.length; i++) {
    System.out.println(myArray[i]);
}