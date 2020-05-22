// Create the zip file:
URI zipURI = URI.create("jar:file:" + fullFilename); // "jar:file:/.../... .zip"
Map<String, Object> env = new HashMap<>(); 
env.put("create", "true");
FileSystem zipFS = FileSystems.newFileSystem(zipURI, env, null);

// Write to aFile1.txt:
Path pathInZipfile = zipFS.getPath("/aFile1.txt");
BufferedWriter out = Files.newBufferedWriter(pathInZipfile,
        StandardCharsets.UTF_8, StandardOpenOption.CREATE_NEW);
out.write("Press any key, except both shift keys\n");
out.close();

// Rename file:
Path pathInZipfile2 = zipFS.getPath("/aFile2.txt");
Files.move(pathInZipfile, pathInZipfile2);

zipFS.close();