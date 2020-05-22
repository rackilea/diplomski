File[] children = parent.listFiles(new FileFilter() {
        public boolean accept(File file) {
            return file.isDirectory() || file.getName().toLowerCase().endsWith(".dat");
        }
    });
// This will return all the files that are directories or whose file name ends
// with ".dat" (*.dat)