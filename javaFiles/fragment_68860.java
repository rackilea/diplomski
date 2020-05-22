private static File[] loadFolder(String string)
{
    File files = new File(string);
    if(!files.exists() || !files.isDirectory()){
        System.out.println("Directory: "+string+" does not exists");       
        return new File[0];
    }

    File[] pngFiles = files.listFiles(new FilenameFilter()
    {
        public boolean accept(File directory, String fileName)
        {
            return fileName.endsWith(".png");
        };
    });
    return pngFiles;
}