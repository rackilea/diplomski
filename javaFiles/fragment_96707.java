PreparedStatement statement = connection.prepareStatement(insertTableSQL);
 for(<the objects you have>) {

   //set parameters into insert query
   statement.set*.*(1, <paramValue>);

   statement.addBatch(); //add it to the batch
 }

 statement.executeBatch();//execute whole batch
 connection.commit();