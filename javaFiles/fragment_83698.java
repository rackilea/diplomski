private static final String crypt1 = "cipherabdfgjk";
private static final String crypt2 = "lmnoqstuvwxyz";

private String decode (String line)
{
  StringBuilder result = new StringBuilder (line.length ());

  for (int i = 0; i < line.length (); ++i)
  {
    char ch = line.charAt (i);

    int index1 = crypt1.indexOf (ch);
    int index2 = crypt2.indexOf (ch);

    if (index1 != -1)
    {
      result.append (crypt2.charAt (index1));
    }
    else if (index2 != -1)
    {
      result.append (crypt1.charAt (index2));
    }
    else
    {
      result.append (ch);
    }
  }

  return result.toString ();
}

/* Takes file source, reads it line by line, decodes each line, then writes the
 * decoded lines to the file destination.
 */
public void decode (String fileSource, String fileDestination) throws IOException
{
  Files.write (Paths.get (fileDestination), 
               Files.lines (Paths.get (fileSource)).
               map (this::decode).
               collect (Collectors.toList ()));
}