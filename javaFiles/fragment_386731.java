public static File fetchConfigFile(file1, file2) {
    if (file1.exists() && file1.isFile()) {
        return file1;
    }
    else if (file2.exists() && file2.isFile()) {
         return file2;
    }
    // Be aware: returning null might not be what you want. 
    return null;
}