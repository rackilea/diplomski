String columnOne = getValue();
String columnTwo = getValue();
String queryString = "SELECT columnOne, columnTwo, columnThree FROM tableOne"

if (columnOne != null && columnTwo != null)
    queryString = queryString + "WHERE columnOne = ? AND columnTwo = ?"
else if (columnOne != null)
    queryString = queryString + "WHERE columnOne = ?"
else if (columnTwo != null)
    queryString = queryString + "WHERE columnTwo = ?"

PreparedStatement query = connection.prepareStatement(queryString);