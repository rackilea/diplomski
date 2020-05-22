File sourceFile = new File( "C:/Users/java/dir1/ss1.txt" );
Path sourcePath = sourceFile.toPath();

File destFile = new File( "C:/Users/java/dir2" );
Path destPath = destFile.toPath();

Files.copy( sourcePath, destPath );