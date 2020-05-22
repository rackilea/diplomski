public static void parseAllFiles(String parentDirectory){   
  File[] filesInDirectory = new File(parentDirectory).listFiles();
  //Added this line.
  if(filesInDirectory != null){   
    for(File f : filesInDirectory){   
      if(f.isDirectory()){   
        parseAllFiles(f.getAbsolutePath());   
      }   
      System.out.println("Current File -> " + f);             
    }
  }
}