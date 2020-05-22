Database database=CommandLineUtils.createDatabaseObject(MySQLConnection.class.getClassLoader(), 
                "jdbc:mysql://localhost:3306/lportal", "root", "admin", "com.mysql.jdbc.Driver", 
                null,null,null);

        Database database2=CommandLineUtils.createDatabaseObject(MySQLConnection.class.getClassLoader(), 
                "jdbc:mysql://localhost:3306/llportal", "root", "admin", "com.mysql.jdbc.Driver",
                null,null,null);
    CommandLineUtils.doDiffToChangeLog("changeLogFile.xml",database, database2)