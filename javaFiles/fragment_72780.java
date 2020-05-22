public class TextFileFilter implements FileFilter
{
  private final String[] okFileExtensions = new String[] {"txt", "doc"};

  public boolean accept(File file)
  {
    for (String extension : okFileExtensions)
    {
      if (file.getName().toLowerCase().endsWith(extension))
      {
        return true;
      }
    }
    return false;
  }
}