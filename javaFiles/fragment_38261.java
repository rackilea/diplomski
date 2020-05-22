private File getUniqueFile(File dir, String prefix) {
    long suffix = System.currentTimeMillis();
    while (true) {
        File file = new File(dir, prefix + suffix);
        // try creating this file, if true then it is unique
        if (file.createNewFile()) {
           return file;
        }
        // someone already has that suffix so ++ and try again
        suffix++;
    }
}