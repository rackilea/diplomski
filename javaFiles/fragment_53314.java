try
   {
    din=new SmbFileInputStream(src);
    dout=new FileOutputStream(Environment.getExternalStorageDirectory()+"/"+src.getName());
    int c;
    while((c=din.read())!=-1)