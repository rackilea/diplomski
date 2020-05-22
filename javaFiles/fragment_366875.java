try {
    appFile = ("../../Sample.zip"); // just the path to zip file
    ZipFile zipFile = new ZipFile(appFile);
    Enumeration<? extends ZipEntry> entries = zipFile.entries();
    while (entries.hasMoreElements()) {
        ZipEntry entry = entries.nextElement();
        if(entry.isDirectory()){
            File file = new File(entry.getName());
            if(file.getParent() == null){
               System.out.println(file.getName());
            }
        }
    }
} catch (IOException e) {
    System.out.println("Error opening Zip" +e);
}