while (true)
{
  String name = (String)ois.readObject();
  if (name.length() == 0) break;
  // "/new/" is the absolute path of the directory where you want all these files to be created
  name += "/new/";

  File dir = new File(name.substring(0, name.lastIndexOf('/')));
  if (!dir.exists())
    dir.mkdirs();

  FileOutputStream fos = new FileOutputStream(new File(name));    

  bytesRead = (Integer) ois.readObject();
  while (bytesRead != BUFFER_SIZE)
  {  
    buffer = (byte[])ois.readObject();
    fos.write(buffer, 0, bytesRead);  
    bytesRead = (Integer) ois.readObject();
  }
  fos.close(); 
}