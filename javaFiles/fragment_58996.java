public void walk(String path) {
     File[] list = new File(path).listFiles();
     if (list == null) return;

     for (File f : list) {
         if ( f.isDirectory() ) {
             walk(f.getAbsolutePath());
         } else {
             if (f.getName().equals("info.txt") || f.getName().equals("full.png")) {
                 f.delete();
             }
         }
    }
}