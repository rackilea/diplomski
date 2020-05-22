private void launch() throws IOException {
    // Get the jar URL which contains the application
    String jarName = "myapplication.jar";
    String strUrl = "jar:http://localhost:8081/" + jarName + "!/";

    Path cacheDir = Paths.get("cache");
    Files.createDirectories(cacheDir);
    Path fetchUrl = fetchUrl(cacheDir, jarName, strUrl);
    JarURLConnection jcl = (JarURLConnection) fetchUrl.toUri().toURL().openConnection();

    Attributes attr = jcl.getMainAttributes();
    String mainClass = (attr != null) ? attr.getValue(Attributes.Name.MAIN_CLASS) : null;
    if (mainClass != null) {
        // launch the program
    }
}

private Path fetchUrl(Path cacheDir, String title, String strUrl) throws IOException {
    Path cacheFile = cacheDir.resolve(title);
    Path cacheFileDate = cacheDir.resolve(title + "_date");
    URL url = new URL(strUrl);
    URLConnection connection = url.openConnection();
    if (Files.exists(cacheFile) && Files.exists(cacheFileDate)) {
        String dateValue = Files.readAllLines(cacheFileDate).get(0);
        connection.addRequestProperty("If-Modified-Since", dateValue);

        String httpStatus = connection.getHeaderField(0);
        if (httpStatus.indexOf(" 304 ") == -1) { // assuming that we get status 200 here instead
            writeFiles(connection, cacheFile, cacheFileDate);
        } else { // else not modified, so do not do anything, we return the cache file
            System.out.println("Using cached file");
        }
    } else {
        writeFiles(connection, cacheFile, cacheFileDate);
    }

    return cacheFile;
}

private void writeFiles(URLConnection connection, Path cacheFile, Path cacheFileDate) throws IOException {
    System.out.println("Creating cache entry");
    try (InputStream inputStream = connection.getInputStream()) {
        Files.copy(inputStream, cacheFile, StandardCopyOption.REPLACE_EXISTING);
    }
    String lastModified = connection.getHeaderField("Last-Modified");
    Files.write(cacheFileDate, lastModified.getBytes());
    System.out.println(connection.getHeaderFields());
}