public static void write(Object item, String path) 
  throws FileNotFoundException, IOException
{
  ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(path));
  try {
    os.writeObject(obj);
  } finally {
    os.close();
  }
}