private boolean checkDatabase() {
    File dbfile = new File(ourContext.getDatabasePath(DATABASE_NAME).getPath());
    if ( dbfile.exists()) return true;
    File dbdir = dbfile.getParentFile();
    if (!dbdir.exists()) {
        dbdir.mkdirs();
    }
    return false;
}