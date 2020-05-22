final URL url = getClass().getResource("/path/to/resource");

if (url == null) // Oops... Resource does not exist
    barf();

final Closer closer = Closer.create();
final InputStream in;
final Scanner scanner;

try {
    in = closer.register(url.openStream());
    scanner = closer.register(new Scanner(in));
    // do stuff
} catch (IOException e) {
    throw closer.rethrow(e);
} finally {
    closer.close();
}