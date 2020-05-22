LineIterator it = FileUtils.lineIterator(file, "UTF-8");
 try {
   while (it.hasNext()) {
    String line = it.nextLine();
     // do something with line
   }
 } finally {
  it.close();
 }