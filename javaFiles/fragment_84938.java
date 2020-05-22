static public boolean deleteDirectory(File path) {
    if( path.exists() ) {
        File[] files = path.listFiles();
        if (files == null) {
            return true;
        }
        for(int i = 0; i < files.length; i++) {
            if(files[i].isDirectory()) {
                deleteDirectory(files[i]);
            }
            else {
                files[i].delete();
            }
            Log.d("Deleting Files", files[i].getPath());
        }
    }

    return( path.delete() );
}