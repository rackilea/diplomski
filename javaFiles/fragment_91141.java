File dir = new File(".");
File [] files = dir.listFiles(new FilenameFilter() {
    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(".xml");
    }
});

for (File xmlfile : files) {
    System.out.println(xmlfile);
}