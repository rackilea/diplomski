class MyClass implements FilenameFilter, Comparator<File> {
    ...

    public boolean accept(File dir, String name) {
         if (name.endsWith(".log") & name.contains("CJL")) 
              return true;
         else
              return false;
    }

    public int compare(File f1, File f2) {
         return Long.valueOf(f1.lastModified()).compareTo(
                 f2.lastModified());
    }

    private String FindLatestFile(String folderPath) {

       File dir = new File(folderPath);

       File[] files = dir.listFiles(this);

       if (files.length > 0) {
            Arrays.sort(files, this);

            File newest = files[files.length - 1];

            return newest.toString;
       } else {
            return "";
       }
}