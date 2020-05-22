mFileName = Environment.getExternalStorageDirectory().getAbsolutePath();
    int entryNumber = 1;
    File mFile = new File(mFileName + "/Recording (" + String.valueOf(entryNumber) + ")" + ".mp3");
    while (mFile.exists()) {
        // File exists, just increment number
        entryNumber++;
    }
    // Only create the file when it does not exists
    mFile = new File(mFileName + "/Recording (" + String.valueOf(entryNumber) + ")" + ".mp3");
    try {
        mFile.createNewFile()
    }
    catch (IOException e) {
        e.printStacjTrace();
    }
    this.mFileName = mFile.getAbsolutePath();