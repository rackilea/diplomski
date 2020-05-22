String query = myProperties.getProperty("some_key");
//Suppose query is 'SELECT * FROM MY_TBL WHERE ID=:myId'

OraclePreparedStatement statement = (OraclePreparedStatement) myConnection.prepareStatement(query);

statement.setStringAtName("myId", "abc2");

someResultSet = statement.executeQuery();