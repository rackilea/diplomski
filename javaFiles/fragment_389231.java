// you may want to actually handle the IOException rather than just throwing it
public static void main(String[] args) throws IOException
{
  makeFileStructure(new File("someDirectory"), "someDestinationDirectory");
}

static void makeFileStructure(File src, String dest) throws IOException
{
  for (File f: src.listFiles())
  {
     String newPath = dest + File.separatorChar + f.getName();
     if (f.isDirectory())
     {
        if (!new File(newPath).mkdirs())
           // you may want to handle this better
           throw new IOException("Directory could not be created!");
        makeFileStructure(f, newPath);
     }
     else
        new File(newPath).createNewFile();
  }
}