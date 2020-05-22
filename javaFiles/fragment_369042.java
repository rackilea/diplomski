Keyspace keyspace = Astyanax.getKeyspaceContext();
    ColumnFamily<String, String> mail = new ColumnFamily<String, String>(
        keyspace.getKeyspaceName(), // CF Name
        StringSerializer.get(),   // Key Serializer
        StringSerializer.get());  // Column Serializer

    // You could start looping here to alter what data is being inserted  
    // or make the method take in parameters and call it multiple times.         
    String  cqlStatement = 
            "INSERT INTO MESSAGE_CF (KEY, DELETED_RECEIVER, DELETED_SENDER, SENDER) "
            + "VALUES ('user-1281324', 'Yes', 'No', 'user@mail.com');";

    // execute the insertion
    OperationResult<CqlResult<String, String>> result = 
        keyspace.prepareQuery(mail).withCql(cqlStatement).execute();

   // stop looping