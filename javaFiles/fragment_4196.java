/**
 * This creates a Zip file at the location specified by zip
 * containing the full directory tree rooted at contents
 *
 * @param zip      the zip file, this must not exist
 * @param contents the root of the directory tree to copy
 * @throws IOException, specific exceptions thrown for specific errors
 */
public static void createZip(final Path zip, final Path contents) throws IOException {
    if (Files.exists(zip)) {
        throw new FileAlreadyExistsException(zip.toString());
    }
    if (!Files.exists(contents)) {
        throw new FileNotFoundException("The location to zip must exist");
    }
    final Map<String, String> env = new HashMap<>();
    //creates a new Zip file rather than attempting to read an existing one
    env.put("create", "true");
    // locate file system by using the syntax
    // defined in java.net.JarURLConnection
    final URI uri = URI.create("jar:file:/" + zip.toString().replace("\\", "/"));
    try (final FileSystem zipFileSystem = FileSystems.newFileSystem(uri, env);
         final Stream<Path> files = Files.walk(contents)) {
        final Path root = zipFileSystem.getPath("/");
        files.forEach(file -> {
            try {
                copyToZip(root, contents, file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}

/**
 * Copy a specific file/folder to the zip archive
 * If the file is a folder, create the folder. Otherwise copy the file
 *
 * @param root     the root of the zip archive
 * @param contents the root of the directory tree being copied, for relativization
 * @param file     the specific file/folder to copy
 */
private static void copyToZip(final Path root, final Path contents, final Path file) throws IOException {
    final Path to = root.resolve(contents.relativize(file).toString());
    if (Files.isDirectory(file)) {
        Files.createDirectories(to);
    } else {
        Files.copy(file, to);
    }
}