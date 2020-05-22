private void recurseDirectory(File f) {

       class InnerClass {

           private long recurseFolder(File f) {
              long folderLength = 0;
              File[] files = f.listFiles();
              for (File file : files) {

                 if (file.isFile()) 
                     { folderLength += file.length(); }

                 else if (f.isDirectory()) 
                     { folderLength += recurseFolder(file); }   
              }
              return folderLength;
          }
      }

    if (f.isFile()) 
        { show f.getAbsolutePath() and f.length() on GUI }

    else if (f.isDirectory()) {

       InnerClass inner = new InnerClass();
       long dirSize = inner.recurseFolder(f);

       show f.getAbsolutePath() and FileUtils.sizeOfDirectory(f) on GUI }

       File[] files = f.listFiles();
       for (File file : files) 
         { recurseDirectory(file); }     
    }
 }