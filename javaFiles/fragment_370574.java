try {
    File sd = Environment.getExternalStorageDirectory();
    File data = Environment.getDataDirectory();
    if (sd.canWrite()) {
        String currentDBPath = "data/"+sPackageName+"/databases/"+sDBName;
        String backupDBPath = "/.appname-external-data-cache/"+sDBName; //"{database name}";
        File dir = new File(sd,backupDBPath.replace(sDBName,""));
        if(dir.mkdir()) {

        }
        File currentDB = new File(data, currentDBPath);
        File backupDB = new File(sd, backupDBPath);
        if (currentDB.exists()) {
            FileChannel src = new FileInputStream(currentDB).getChannel();
            FileChannel dst = new FileOutputStream(backupDB).getChannel();
            dst.transferFrom(src, 0, src.size());
            src.close();
            dst.close();
        }
    }