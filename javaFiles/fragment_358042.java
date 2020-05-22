// create the "top" array
JSONArray topArray = new JSONArray();

// add your static "headers"
JSONArray headers = new JSONArray();
headers.put("Command");
headers.put("Book Issued");
topArray.put(headers);

while (rs.next()){   
    // create a new array for the current record
    JSONArray recordArray = new JSONArray(); 
    // populate the record array                                                                                             
    String zone = rs.getString("command");
    recordArray.put(zone);
    int booksissued = rs.getInt("books_issued");
    recordArray.put(booksissued);

    // append the record array to the top array
    topArray.put(recordArray);
}

return topArray;