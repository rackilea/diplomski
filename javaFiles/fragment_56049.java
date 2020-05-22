public static InputStream createInputStream(String resource)
{
     resource = resource.trim();

     if (resource.startsWith("http:"))
     {
          return new URL(resource).openStream();
     } else
     {
          return new FileInputStream(new File(resource));
     }
}

public static BufferedReader createReader(InputStream is, String charset)
{
     return new BufferedReader(new InputStreamReader(is, charset));
}