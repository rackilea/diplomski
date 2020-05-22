if(CLASS_NAME.equals(name)) {

    // two ways of doing this - either load the library explicitly from the full path  
    if (useFullPath) {
      Runtime.getRuntime().loadLibrary("/full/path/to/mylibrary");
    }
    else { // or tweaking the library path
      System.setProperty("java.library.path", 
         System.getProperty("java.library.path")
         + System.getProperty("file.separator")
         + "/path/to/lib");
    }
 }
 return super.loadClass(name);