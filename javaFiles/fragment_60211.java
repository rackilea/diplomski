DSL.using(configuration)
   .transaction((Configuration c) -> {
       Connection connection = c.connectionProvider().acquire();
       try {
           LargeObjectManager manager = connection.unwrap(PGConnection.class).getLargeObjectAPI();
           // ...
       }
       finally {
           c.connectionProvider().release(connection);
       }
   });