String[] myDirectories = {"","",""......}; // your list of directories

for (String directory : myDirectories ) {
  File file = new File(directory);
   if(file.exists() && file.isDirectory())
      // Do something you have found your directory

}