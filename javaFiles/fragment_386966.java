String inputQry = "INSERT INTO(\"TEST1\", \"TEST2\") VALUES(\"TEST3\", \"TEST4\");";

Integer indexOfValuesClause = inputQry.indexOf("VALUES"); // index where VALUES start
String firstPart = inputQry.substring(0,indexOfValuesClause); // first part contains String upto VALUES clause
firstPart = firstPart.replace("\"","'");
System.out.println(firstPart+inputQry.substring(indexOfValuesClause));