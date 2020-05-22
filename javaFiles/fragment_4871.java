public static void main(String[] args) throws IOException {
    File directory = new File("/logFiles");
    purgeLogFiles(directory);
}

public void purgeLogFiles(File logDir){
    File[] logFiles = logDir.listFiles();
    long oldestDate = Long.MAX_VALUE;
    File oldestFile = null;
    if( logFiles != null && logFiles.length >499){
        //delete oldest files after theres more than 500 log files
        for(File f: logFiles){
            if(f.lastModified() < oldestDate){
                oldestDate = f.lastModified();
                oldestFile = f;
            }               
        }

        if(oldestFile != null){
            oldestFile.delete();
        }
    }
}