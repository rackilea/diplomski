Path dir = Paths.get( universal, "Downloads" );
Path renameTo = Paths.get( universal, "Downloads", "allPi.txt" );
try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, timeStampString + "*" )) {
    Iterator<Path> iterator = stream.iterator();
    if ( iterator.hasNext() ) {
        Path path = iterator.next();
        Files.move( path, renameTo, StandardCopyOption.REPLACE_EXISTING );
    }
}