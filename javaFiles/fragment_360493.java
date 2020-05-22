File dir = new File("directory"); // directory = target directory.
if(dir.exists()) // Directory exists then proceed.
{ 
  Pattern p = Pattern.compile("keyword"); // keyword = keyword to search in files.
  ArrayList<String> list = new ArrayList<String>(); // list of files.

  for(File f : dir.listFiles())
  {
    if(!f.isFile()) continue;
    try
    {
      FileInputStream fis = new FileInputStream(f);
      byte[] data = new byte[fis.available()];
      fis.read(data);
      String text = new String(data);
      Matcher m = p.matcher(text);
      if(m.find())
      {
        list.add(f.getName()); // add file to found-keyword list.
      }
      fis.close();
    } 
    catch(Exception e)
    {
      System.out.print("\n\t Error processing file : "+f.getName());
    }

  }
  System.out.print("\n\t List : "+list); // list of files containing keyword.
} // IF directory exists then only process.
else
{
  System.out.print("\n Directory doesn't exist.");
}