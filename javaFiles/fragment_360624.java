public DBRestorerWorker(String dbName, Path fromFile, Path targetDataPath,
    Path targetLogPath, Properties properties, Runnable done) {

    DBRestorerWorker(dbName, fromFile, targetDataPath, targetLogPath, null,
        properties, done);
}