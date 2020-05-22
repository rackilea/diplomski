private File[] compactor(File[] files) {
    int deleted = 0;
    for (int i = 0; i < files.length; i++) {
        File file = files[i];
        if (file.exists()) {
            files[i - deleted] = file;
        } else {
            files[i] = null;
            deleted++;
        }
    }

    int nSize = files.length - deleted;
    File[] newFiles = new File[nSize];
    if (nSize > 0) {
        System.arraycopy(files, 0, newFiles, 0, newFiles.length);
    }
    System.out.println(Arrays.toString(newFiles));
    return newFiles;
}