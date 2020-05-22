try{
    //packagesize is header information which is sent in advance
    index.putInt(packagesize);

    byte c[]= {index.get(3),index.get(2),index.get(1),index.get(0)};

    InputStream jpgimage = new FileInputStream(fileimage);          

    dataOutputStream = new BufferedOutputStream(socket.getOutputStream());
    dataInputStream = new BufferedInputStream(socket.getInputStream());

    int writeBytes = 0,len = 0;
    byte buffer[] = new byte[1024];

    while((len = jpgimage.read(buffer,0,buffer.length))!=-1)
    {
        writeBytes+=len;                
        dataOutputStream.write(buffer,0,len);

    }       

    dataOutputStream.flush();
    jpgimage.close();
    dataInputStream.close();
    dataOutputStream.close();

     ...
     ...
     ...