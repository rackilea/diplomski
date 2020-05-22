DSL.using(configuration)
   .transaction((Configuration c) -> {
       DSL.using(c).connection(connection -> {
           LargeObjectManager manager = connection.unwrap(PGConnection.class).getLargeObjectAPI();
           // ...
       });
   });