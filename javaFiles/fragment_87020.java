walkdir(dir);

 ArrayList<String> filepath= new ArrayList<String>();//contains list of all files ending with 

public void walkdir(File dir) {
 File listFile[] = dir.listFiles();

if (listFile != null) {
 for (int i = 0; i < listFile.length; i++) {

 if (listFile[i].isDirectory()) {// if its a directory need to get the files under that directory
  walkdir(listFile[i]);
} else {// add path of  files to your arraylist for later use

  //Do what ever u want
  filepath.add( listFile[i].getAbsolutePath());

 }
 }  
}    
}