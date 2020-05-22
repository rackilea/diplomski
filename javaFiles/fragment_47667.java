FileFilter filterWithoutExtension = new FileFilter() {

        @Override
        public boolean accept(File f) {
            // This will display only the files without "."
            return !f.getName().contains(".");
        }

        @Override
        public String getDescription() {
            return "Files Without Extension";
        }
};