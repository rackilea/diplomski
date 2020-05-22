public void find_files(File root)
{
    File[] files = root.listFiles(); 
    for (File file : files) {
        if (file.isFile()) {
            ...
        } else if (file.isDirectory()) {
            find_files(file);
        }
    }
}