public class FileReaderTest
{
  public static void main(String[] args) throws IOException, IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException
  {
    final FileReaderTest object = new FileReaderTest(); 

    final BufferedReader reader = new BufferedReader(new FileReader(new File("/path/to/file")));
    for (String line = reader.readLine(); line != null; line = reader.readLine())
    {
      object.getClass().getMethod(line).invoke(object);
    }
  }
}