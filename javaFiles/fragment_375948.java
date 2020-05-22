try {
        //Create handle to SD card drectory
        exportDirectory = new File(Environment.getExternalStorageDirectory() + "/MyDir");

        //Verify export path exists.  Create otherwise.
        if (exportDirectory.exists() == false) {
            if (exportDirectory.mkdirs() == false) {

                //Directory structure could not be created.
                //Message the user here
                return false;
            }
        }

        //Create handle to SD card file.
        exportFile = new File(exportDirectory.getAbsolutePath() + "/whatever.mp3");

        //Do whatever here

} catch(Exception e) {
        //Exception.  Message user and bail
        return false;
}