class <className>
{

   List arrayList;

   File file;
  //you should initialize the file and the arraylist first
  public void reWrite()
  {
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
      for(Object object : arraylist)
      {
         bw.write(object);
      }
        bw.close();
  } 
 }