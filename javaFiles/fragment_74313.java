String path = Environment.getExternalStorageDirectory().toString()+"/Download";
File f = new File(path);        
File files[] = f.listFiles();   
for (File f : files)
     {
      String fullPath = f.getAbsolutePath();
      int dot = fullPath.lastIndexOf(".");
      String ext = fullPath.substring(dot + 1);
      if(ext.equals("pdf"))
      {
        //do something with f here
      } 
     }