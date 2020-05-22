public void appendData(String text)
{       
    File myFile = new File("sdcard/myfile.file");
    if (!myFile.exists())
    {
      try
      {
          myFile.createNewFile();
      } 
      catch (IOException e)
      {
          // TODO Auto-generated catch block
          e.printStackTrace();
      }
  }
  try
  {
      //BufferedWriter for performance, true to set append to file flag
      BufferedWriter buf = new BufferedWriter(new FileWriter(myFile, true)); 
      buf.append(text);
      buf.newLine();
      buf.close();
  }
  catch (IOException e)
  {
      // TODO Auto-generated catch block
      e.printStackTrace();
  }
}