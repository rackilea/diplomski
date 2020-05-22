statement.addBatch("DROP TABLE IF EXISTS  account ");
statement.addBatch("CREATE TABLE  account ( "
                     +"accountNum INT( 11 ),"
                     +"dateCreated DATE NOT NULL,"
                     +"accountName TEXT,"
                     +"description TEXT,"
                     +"statusAccount TEXT,"
                     +"sumOfMoney INT( 11 ) NOT NULL DEFAULT  0 )" )  ;
statement.executeBatch();