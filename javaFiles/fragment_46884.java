public static void main(final String... args)
    throws UnsupportedEncodingException, URISyntaxException
{
    System.out.println(URLDecoder.decode("a+b", "UTF-8"));
    System.out.println(new URI("http", "foo.bar", "/baz", "op=a+b", null));
    System.out.println(new URI("http", "foo.bar", "/baz", "op=a b", null));
}