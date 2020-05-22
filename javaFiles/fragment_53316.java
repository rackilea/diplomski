if(src.isFile()){
    din=new SmbFileInputStream(src);
    //dout=new FileOutputStream(Environment.getExternalStorageDirectory()+"/"+src.getName());// REMOVE THIS LINE
    File outputFile = new File(Environment.getExternalStorageDirectory()+"/"+src.getName()); // ADDED
    outputFile.mkdirs();  // ADDED
    dout=new FileOutputStream(outputFile);  // ADDED
}
else {
    //din=new SmbFileInputStream(src); // REMOVE THIS LINE
    File outputFile = new File(Environment.getExternalStorageDirectory()+"/"+src.getName());
    outputFile.mkdirs(); 
    //dout=new FileOutputStream(outputFile); // REMOVE THIS LINE
}