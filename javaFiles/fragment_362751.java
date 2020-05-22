String url = "jdbc:h2:mem:test;" + 
             "INIT=CREATE SCHEMA IF NOT EXISTS TEST"
String url = "jdbc:h2:mem:test;" + 
             "INIT=CREATE SCHEMA IF NOT EXISTS TEST\\;" + 
                  "SET SCHEMA TEST";
String url = "jdbc:h2:mem;" + 
             "INIT=RUNSCRIPT FROM '~/create.sql'\\;" + 
                  "RUNSCRIPT FROM '~/populate.sql'";