Path start = Paths.get(new URI("file:///my/folder/"));

Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
     @Override
     public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) 
        throws IOException
     {
         System.out.println(file);
         return FileVisitResult.CONTINUE;
     }
     @Override
     public FileVisitResult postVisitDirectory(Path dir, IOException e)
        throws IOException
     {
         if (e == null) {
             System.out.println(dir);
             return FileVisitResult.CONTINUE;
         } 
         else {
             // directory iteration failed
             throw e;
         }
     }
 });