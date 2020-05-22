public static void main(String[] args) throws IOException {
    Iterator<File> files = FileUtils.iterateFiles(new File("/path/to/v3"), new String[]{"jsp"}, true);
    while (files.hasNext()) {
        File jsp =  files.next();
        List<String> list = FileUtils.readLines(jsp);
        for (String line : list) {
            if(line.startsWith("<link") || line.startsWith("<script")) {
                if(!line.contains("/static")) {
                    throw new RuntimeException("invalid file found: " + jsp.getAbsolutePath());
                }
            }
        }
    }
}