Files.walkFileTree(path,new SimpleFileVisitor<Path>()
{
   public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes attrs) throws IOException
   {
       if(attrs.isDirectory())
       {
           keyMap.put(path.register(svc, StandardWatchEventKinds.ENTRY_CREATE),path);
       }
       return FileVisitResult.CONTINUE;
   }
});