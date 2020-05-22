public static void main(final String... args)
    throws URITemplateException, MalformedURLException
{
    final URITemplate template 
        = new URITemplate("http://www.thomsonlocal.com/Electricians/UK/#{+var}");

    final VariableMap map = VariableMap.newBuilder()
        .addScalarValue("var", "||25")
        .freeze();

    System.out.println(template.toURL(map));
}