void processFile(File file, String path)
{
  if (file.isDirectory())
  {
    File[] children = file.listFiles();
    for (File child : children)
    {
      all.add(child);
      processFile(child, path + file.getName() + "/");
    }
  }
  else
  {
    oos.writeObject(path + child.getName());
    FileInputStream fis = new FileInputStream(child);  
    while ((bytesRead = fis.read(buffer)) > 0)
    {  
      oos.writeObject(bytesRead);  
      oos.writeObject(buffer);  
    }
    oos.writeObject(BUFFER_SIZE);
  }
}