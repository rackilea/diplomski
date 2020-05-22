File dir = new File("/dir/app/");
File [] files = dir.listFiles(new FilenameFilter() {
    @Override
    public boolean accept(File dir, String name) {
        return name.startsWith("hello.myapp-") && name.endsWith(".apk");
    }
});

for (File file : files) {
    //do stuff with file
}