String filenameFullNoPath = fileTimestamp + "_"  + fileDBSize + "-" 
        + fileName + ".csv";
  File myFile =  new File(System.getProperty("user.dir")  + File.separator 
        + "output" + File.separator + filenameFullNoPath);
  File parentDir = myFile.getParentFile();
  if(! parentDir.exists()) 
      parentDir.mkdirs(); // create parent dir and ancestors if necessary
  // FileWriter does not allow to specify charset, better use this:
  Writer w = new OutputStreamWriter(new FileOutputStream(myFile),charset);