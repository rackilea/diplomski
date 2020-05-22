String query = "INSERT INTO " + Table_variables + " VALUES('" + plcData + "', '" + agencyName + "','" + list.get(0) + "','" + list.get(1) + "','" + list.get(2) + "','" + list.get(3) + "','" + list.get(4) + "','" + list.get(5) + "','" + list.get(6) + "','" + list.get(7) + "','" + list.get(8) + "','" + userid + "');";
String query1 = "INSERT INTO " + Table_values + " VALUES('" + plcData + "','" + agencyName + "','" + list1.get(0) + "','" + list1.get(1) + "','" + list1.get(2) + "','" + list1.get(3) + "','" + list1.get(4) + "','" + list1.get(5) + "','" + list1.get(6) + "','" + list1.get(7) + "','" + list1.get(8) + "','" + userid + "');";
String query2 = "INSERT INTO " + Table_ListId + " VALUES('" + plcData + "','" + agencyName + "','" + list2.get(0) + "','" + list2.get(1) + "','" + list2.get(2) + "','" + list2.get(3) + "','" + list2.get(4) + "','" + list2.get(5) + "','" + list2.get(6) + "','" + list2.get(7) + "','" + list2.get(8) + "','" + userid + "');";

try {
     myDB.execSQL(query);
     myDB.execSQL(query1);
     myDB.execSQL(query2);

} catch(SQLException se) {
     //do stuff when you catch a duplicate ID
 }