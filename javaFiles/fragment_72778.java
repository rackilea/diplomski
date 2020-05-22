public class TextFileFilter implements FileFilter
{
  private final String TXT = "txt";

  public boolean accept(File file)
  {
    if (file.getName().toLowerCase().endsWith(TXT))
      return true;
    else
      return false;
  }
}