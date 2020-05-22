new FilenameFilter() {
     @Override
     public boolean accept(File dir, String filename) {
         // create a file object to check whether we are looking at a directory.
         File f = new File(dir, filename); 
         return f.isDirectory() || filename.toLowerCase().endsWith(".rar");
     }
 }