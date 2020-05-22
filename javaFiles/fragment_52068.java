URLConnection connection = url1.openConnection();

Map responseMap = connection.getHeaderFields();
Iterator iterator = responseMap.entrySet().iterator();
while (iterator.hasNext())
{
    String key = iterator.next().toString();
    if (key.contains("Content-Type"))
    {
        System.out.println(key);
        // Content-Type=[text/html; charset=ISO-8859-1]
        if (filters.matcher(key) != null){
            System.out.println(url1);
            // http://google.com
        }
    }
}