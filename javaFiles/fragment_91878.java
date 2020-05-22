public static FileFilter getFilter() {
    Pattern p = Pattern.compile("application(?:#[^.]*)?\\.xml(?:\\.\\d{4}-\\d{2}-\\d{2})?");
    FileFilter patternFilter = new FileFilter() {
        @Override
        public boolean accept(final File file) {
           return p.matcher(file.getName()).matches();
        };
        return patternFilter;
    }
}