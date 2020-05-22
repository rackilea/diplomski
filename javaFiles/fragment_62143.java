List<String> paths = new ArrayList<String>();
File directory = new File("/mnt/sdcard/folder");

File[] files = directory.listFiles();

for (int i = 0; i < files.length; ++i) {
    paths.add(files[i].getAbsolutePath());
}