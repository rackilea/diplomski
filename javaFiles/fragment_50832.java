public File createFileStructure(hostName, userName) {
  File baseUserDirectory = new File(hostName, userName);
  String userFileNameToBeCreated = "yyyyMMddHHmm.txt";
   if(!baseUserDirectory.exists()) {
     if(!baseUserDirectory.mkdirs()) {
         throw new IllegalStateException("The base user directory does not exist and could not be created: "
                   + baseUserDirectory);
       }
   }
   if(baseUserDirectory.isDirectory ()) {
     throw new IllegalStateException("The base user directory is not a directory: " + baseUserDirectory);
   }
   //till here you will be sure that your user Directory exists.
   return new File(baseUserDirectory, userFileNameToBeCreated);
  }