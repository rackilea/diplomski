// Define in and out filepaths
String DB_INPUT = "/data/data/com.package.name/databases/database.db";
String DB_OUTPUT = activity.getDatabasePath("database.db").getPath();

// Create empty database to grant permissions
SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(DB_OUTPUT, null);
db.close();

try {
    // Request superuser permissions
    Process suProcess = Runtime.getRuntime().exec("su");
    DataOutputStream suOutputStream = new DataOutputStream(suProcess.getOutputStream());

    // Copy database
    suOutputStream.writeBytes("cat " + DB_INPUT + " > " + DB_OUTPUT + "\n");

    // Close terminal
    suOutputStream.writeBytes("exit\n");
    suProcess.waitFor();
    suOutputStream.close();
} catch(Exception e) {
    Log.e(LOGTAG, "Something went terrible wrong: " + e.getMessage());
}