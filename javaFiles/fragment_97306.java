public static ArrayList getFilesInDirectoryRec(File path, 
        boolean readHiddenFiles) throws ZipException {

    if (path == null) {
        throw new ZipException("input path is null, cannot read files in the directory");
    }

    ArrayList result = new ArrayList();
    File[] filesAndDirs = path.listFiles();
    List filesDirs = Arrays.asList(filesAndDirs);

    if (!path.canRead()) {
        return result; 
    }

    for(int i = 0; i < filesDirs.size(); i++) {
        File file = (File)filesDirs.get(i);
        if (file.isHidden() && !readHiddenFiles) {
            // The first hidden file causes a return and skipping everything else (!)
            return result;
        }
        result.add(file);
        if (file.isDirectory()) {
            List deeperList = getFilesInDirectoryRec(file, readHiddenFiles);
            result.addAll(deeperList);
        }
    }
    return result;
}