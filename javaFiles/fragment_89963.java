public static String getFirstZipFilename(File dir) {        
    for (File file : dir.listFiles()) {
        String filePath = file.getPath();
        if (file.isFile() && filePath.endsWith(".zip")) {
            return filePath;
        }
    }

    return null;
}