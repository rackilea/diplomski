File sdStorage;
if(sdStorage.isExternalStorageRemovable()) {
     sdStorage = Environment.getExternalStorageDirectory();
} else {
    List<File> storages = Environment.getExternalStorageDirectory().getParentFile().listFiles();
    for(File storage : storages) {
        if(! storages.equals(Environment.getExternalStorageDirectory()) {
            sdStorage = storage;
            break;
        }
    }
}
if(sdStorage == null) {
    // No non-removable storage device was found
}