File fMysqlPath = new File("C:\\Program Files\\MySQL\\MySQL Server 5.1\\bin\\");
String executeCmd = "mysqldump -u " + dbUser
            + " -p" + dbPass + " " + dbName + " -r " + FilePath + "\\"
            + FileName;

System.out.println(executeCmd);
Process runtimeProcess = Runtime.getRuntime().exec(executeCmd, null, fMysqlPath);