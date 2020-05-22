com.ibm.db2.jcc.DB2DataSource ds = 
          new com.ibm.db2.jcc.DB2DataSource();                                       

       ds.setDriverType(4);
       ds.setServerName("localhost");                             
       ds.setPortNumber(50000);                                   
       ds.setDatabaseName("sample");                              
       ds.setUser("username");                                  
       ds.setPassword("password");                              
       ds.setClientProgramName("My application");