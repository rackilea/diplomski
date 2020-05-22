//Get timezone from first entry, assuming all same timezone
if(!downloadTimes.isEmpty()) {
    cal.setTimeZone(downloadTimes.get(0).getTimeZone());
}

//Create an array of timestamps
java.sql.Timestamp [] array = new java.sql.Timestamp [downloadTimes.size()];

for(int i=0; i < array.length; i++) {
    array[i] = new java.sql.Timestamp(downloadTimes.get(i).getTimeInMillis());
} 

//pass the array to JDBC call
//conn is the connection, and cstmt is the CallableStatement
Array sqlArray = conn.createArrayOf("timestamp", array);
cstmt.setArray(4, sqlArray);