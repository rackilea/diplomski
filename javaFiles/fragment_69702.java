statement.executeUpdate("DROP TABLE IF EXISTS  account ");
statement.executeUpdate("CREATE TABLE  account ( "
                     +"accountNum INT( 11 ),"
                     +"dateCreated DATE NOT NULL,"
                     +"accountName TEXT,"
                     +"description TEXT,"
                     +"statusAccount TEXT,"
                     +"sumOfMoney INT( 11 ) NOT NULL DEFAULT  0 )" )  ;