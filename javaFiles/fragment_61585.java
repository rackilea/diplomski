boolean isDirectory(File f) {
        try {
            return f.isDirectory();
        } catch (SecurityException e) {
            excs.add(e);
            return false;
        }
    }
    boolean isFile(File f) {
        try {
            return f.isFile();
        } catch (SecurityException e) {
            excs.add(e);
            return false;
        }
    }
    List<File> getChildren(File root) {
        File[] children;
        try {
            children = root.listFiles();
        } catch (SecurityException e) {
            excs.add(e);
            return Collections.emptyList();
        }
        if (children == null) {
            excs.add(new IOException("IOException|listFile|" + root));
            return Collections.emptyList();
        }
        return Arrays.asList(children);
    }
}