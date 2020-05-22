File sdcard = Environment.getExternalStorageDirectory();
    File outputFile = new File(sdcard, "android/package/databases/mydatabase.
    File data = Environment.getDataDirectory();
    File inputFile = new File(data, "data/package/databases/database");

    InputStream input = new FileInputStream(inputFile);
    OutputStream output = new FileOutputStream(outputFile);