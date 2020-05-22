public List<File> findFiles(String path){
    List<File> list = new ArrayList<File>();
    File[] files = new File(path).listFiles();
    for(File objects : files) {
         if(objects.isFile()) {
             list.add(objects);
         }
         //goes to the deeper layer
         else if(objects.isDirectory()) {
             list.addAll(findFiles(objects.getAbsolutePath()));
         }
     }
     return list;
}