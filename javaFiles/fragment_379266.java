updateDirectory.list(new FilenameFilter() {
        @Override
        public boolean accept(File dir, String name) {
            return name.startsWith(".");
        }
    });