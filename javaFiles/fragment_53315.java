try
   {
    din=new SmbFileInputStream(src);

    File outputFile = new File(Environment.getExternalStorageDirectory()+"/"+src.getName()); // ADDED
    outputFile.mkdirs(); // ADDED

    dout=new FileOutputStream(outputFile); // CHANGED
    int c;
    while((c=din.read())!=-1)