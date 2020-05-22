String backupCmd = “mysqldump -u “+dbUser+” -p”+dbPass+” “+dbName+” -r backup.sql”;

// Tun mysql backup
Process process = Runtime.getRuntime().exec(backupCmd);

process.waitFor();
int exitCode = exitValue();

 if(exitCode == 0){    
    System.out.println(“Successfully created mysql backup”);    
} else {    
    System.out.println(“Failed to create mysql backup”);    
}