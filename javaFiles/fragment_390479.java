myPrepdStmt = myConn.prepareStatement(myStrngBldr.toString());

myPrepdStmt.setInt(1, routes.get(i).ID);
myPrepdStmt.setFloat(2, routes.get(i).driveTime);
...
myPrepdStmt.executeUpdate();