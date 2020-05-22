public static void main(String[] args) 
{

  // Directory path here
  String path = "."; 

  String files;
  File folder = new File(path);
  File[] listOfFiles = folder.listFiles(); 

  for (int i = 0; i < listOfFiles.length; i++) 
  {

   if (listOfFiles[i].isFile()) 
   {
   files = listOfFiles[i].getName();
       if (files.endsWith(".rar") || files.endsWith(".zip"))
       {
          System.out.println(files);
        }
     }
  }
}