public class MyBackupAgent extends BackupAgentHelper {

    private String KEY = "key";

    @Override
    public void onCreate() {
        addHelper(KEY, new FileBackupHelper(this, DATABASE_NAME));
    }

    @Override
    public File getFilesDir(){
        File path = getDatabasePath(DATABASE_NAME);
        return path.getParentFile();
    }

    @Override
    public void onBackup(ParcelFileDescriptor oldState, BackupDataOutput data, ParcelFileDescriptor newState) throws IOException {
        super.onBackup(oldState, data, newState);
    }

    @Override
    public void onRestore(BackupDataInput data, int appVersionCode, ParcelFileDescriptor newState) throws IOException {
        super.onRestore(data, appVersionCode, newState);
    }
}