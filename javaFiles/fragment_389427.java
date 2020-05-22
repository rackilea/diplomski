Keep Seperate Sockets that makes it simpler,or you need syncronisation

1)use objectoutputstream for image thats fastest method of image transfer

2)use dataoutputstream for string

Image Sending code

      File myFile = new File ("d:\\ab.jpg");
      byte [] mybytearray  = new byte [(int)myFile.length()];
      FileInputStream fis = new FileInputStream(myFile);
      BufferedInputStream bis = new BufferedInputStream(fis);
      bis.read(mybytearray,0,mybytearray.length);
      OutputStream os = sock.getOutputStream();
      System.out.println("Sending...");
      os.write(mybytearray,0,mybytearray.length);
      os.flush();
      os.close();

Image receiving code

    int filesize=6022386; // filesize temporary hardcoded
    long start = System.currentTimeMillis();
    int bytesRead;
    int current = 0;

    File f=new File("d:\\ab.jpg");
    f.createNewFile();
    // receive file
    byte [] mybytearray  = new byte [filesize];
    InputStream is = socket.getInputStream();
    FileOutputStream fos = new FileOutputStream(f);
    BufferedOutputStream bos = new BufferedOutputStream(fos);
    bytesRead = is.read(mybytearray,0,mybytearray.length);
    current = bytesRead;
   do {
       bytesRead =
       is.read(mybytearray, current, (mybytearray.length-current));
       if(bytesRead >= 0) current += bytesRead;
    } while(bytesRead > -1);
    count=current;
    Copy=mybytearray.clone();
    bos.write(mybytearray, 0 , current);
    bos.flush();
    long end = System.currentTimeMillis();
    System.out.println(end-start);
    bos.close();
    fos.close();
    Status=true;