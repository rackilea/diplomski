final URL url = getClass().getResource("/path/to/resource");

if (url == null) // Oops... Resource does not exist
    barf();

final InputStream in;
final Scanner scanner;

try (
    in = url.openStream();
    scanner = new Scanner(in);
) {
    // do stuff
} catch (IOException e) {
    // deal with the exception if needed; or just declare it at the method level
}