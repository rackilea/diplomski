File dbBackUpFile = new File("db.sql");

File mysqlDir = new File("\\\\192.168.0.44\\xampp\\mysql");
File mysqlBinDir = new File(mysqlDir, "bin");
File mysqlumpFile = new File(mysqlBinDir, "mysqldump.exe");
String dbUser = "myUserName";
String dbPass = "myPassword";
String dbName = "myDbName";
String dbIp = "192.168.0.44";
    String executeCmd = "";
    executeCmd = mysqlumpFile + " " + dbName + " -u " + dbUser + " -h " + dbIp
            + " --password=" + dbPass + " " + "  -r \""
            + dbBackUpFile.getAbsolutePath() + "\"";