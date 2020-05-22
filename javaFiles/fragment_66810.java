public void checkDB() {
    try {

        //android default database location is : /data/data/youapppackagename/databases/
        String packageName = this.getPackageName();
        String destPath = "/data/data/" + packageName + "/databases";
        String fullPath = "/data/data/" + packageName + "/databases/"
                + DATABASE_NAME;

        //this database folder location
        File f = new File(destPath);

        //this database file location
        File obj = new File(fullPath);

        //check if databases folder exists or not. if not create it
        if (!f.exists()) {
            f.mkdirs();
            f.createNewFile();
        }

        //check database file exists or not, if not copy database from assets
        if (!obj.exists()) {
            this.CopyDB(fullPath);
        }

    } catch (FileNotFoundException e) {
        e.printStackTrace();

    } catch (IOException e) {
        e.printStackTrace();

    }
}