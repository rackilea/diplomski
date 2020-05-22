public static void findFilesRecursively(String directoryName, List<File> files, Pattern pattern) {
    File directory = new File(directoryName);

    // get all the files from a directory
    File[] fList = directory.listFiles();
    for (File file : fList) {
        if (file.isFile()) {
            if(pattern.matcher(file.getName()).find()) {
                files.add(file);
            }
        } else if (file.isDirectory()) {
            findFilesRecursively(file.getAbsolutePath(), files, pattern);
        }
    }
    File dir = Environment.getExternalStorageDirectory();
    List<File> fileResult = new ArrayList<File>();
    findFilesRecursively(dir.getAbsolutePath(), fileResult,Pattern.compile(".*\\.mp3$"));