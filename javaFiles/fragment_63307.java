File[] imagelist = filePath.listFiles(new FilenameFilter(){
  public boolean accept(File dir, String name){
    if(!(name.endsWith(".jpg") || name.endsWith(".png")) return false; // Only need images
    for(String validName: namesArray){
      // If the names in the list include the file extention then use this line
      if(name.equals(validName)) return true;
      // Otherwise If the names in the list don't include the file extention then use these lines
      if(name.endsWith(".jpg") && name.substring(0, name.lastIndexOf(".jpg")).equals(validName)) return true;
      if(name.endsWith(".png") && name.substring(0, name.lastIndexOf(".png")).equals(validName)) return true;
    }
    return false;
  }  
});