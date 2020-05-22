File directory = new File("/incoming/external/data");
String[] fileNames = directory.list(new FilenameFilter() {
    public boolean accept(File dir, String fileName) {
         return fileName.endsWith(".csv");
    }
});