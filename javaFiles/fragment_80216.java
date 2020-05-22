FileSystem fileSystem = FileSystem.newInstance(workingDir.toUri(), fsConfig);
FileStatus[] fileStatuses = FileSystem.listStatus(workingDir);
  for(FileStatus fileStatus : fileStatuses){
    if(fileStatus.isFile()){
       final Path filePath = fileStatus.getPath();
       long modificationTime = fileStatus.getModificationTime();
       Thread.sleep(4000);
       long modTimeAfterSleep = fileStatus.getModificationTime();
     if(modTimeAfterSleep - modificationTime  == 0){
         System.out.println("File fully copied");
     } else {
       System.out.println("Keep fishing..");
     }
}