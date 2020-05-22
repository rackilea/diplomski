JSONArray arry = new JSONArray();
String finalDate = null;
finalDate = "Date.UTC("+splitted[0]+", " + month + ", " + splitted[2].substring(0,2) + ", " + split3[0] + ", " +split3[1]+ ", 00), " + c.getDouble(c.getColumnIndexOrThrow("glucose")) ;
arry.put(finalDate);

// ...
resultSet.put(arry);