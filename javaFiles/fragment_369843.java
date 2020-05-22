void deleteFiles(Context context) {
    File rootFolder = context.getFilesDir();
    File fileDir = new File( rootFolder,getAlbumId());
    if (fileDir.exists()) {
        File[] listFiles = fileDir.listFiles();
        for (File listFile : listFiles) {
        if (!listFile.delete()) {
            System.err.println( "Unable to delete file: " + listFile );
        }
        }
    }
    rootFolder.delete();
}