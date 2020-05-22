private void printContents(File directory){
  for(File f : directory.listFiles()){
   System.out.println(f);
   if(f.isDirectory())
    printContents(f);
  }
}