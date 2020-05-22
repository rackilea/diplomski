while (iterator.hasNext())
{
    String key = iterator.next().toString();
    if (key.contains("text/html"))
    {
        System.out.println(url1);
        // http://google.com
    }
}