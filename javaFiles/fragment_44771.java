public final class Foo
{
    private static final List<String> INPUTS = Arrays.asList(
        "/foo", "//foo", "foo/", "foo/bar", "foo/bar/../baz", "foo//bar"
    );

    public static void main(final String... args)
    {
        Path path;

        for (final String input: INPUTS) {
            path = Paths.get("/", input).normalize();
            System.out.printf("%s -> %s\n", input, path);
        }
    }
}