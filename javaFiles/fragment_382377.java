public File[] listFiles(File dir, FileFilter filter) throws IOException {
    if (dir.exists()) {
        if (dir.isDirectory()) {
            return dir.listFiles(filter);
        } else {
            throw new IOException(dir + " is not a valid directory");
        }
    } else {
            throw new IOException(dir + " does not exist");
    }
}