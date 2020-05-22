public static String encode(String urlString) throws UnsupportedEncodingException
{
    try
    {
        URI uri = new URI(urlString);
        return uri.toASCIIString();
    }
    catch (URISyntaxException e)
    {
        e.printStackTrace();
    }
}