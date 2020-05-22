File fileDirectory = new File(Environment.getExternalStorageDirectory() + "/SavedFiles", "");
    if (!fileDirectory.exists())
            {
                fileDirectory.mkdirs();
            }
    File file = new File(fileDirectory, "newfile.txt");