try{
    byte[] bytes = new byte[1024];

    FileInputStream fis = new FileInputStream(file);
    OutputStream os = socket.getOutputStream();
    BufferedOutputStream bos = new BufferedOutputStream(os);

    PrinterWriter pw = new PrintWriter(bos);
    pw.println(file.getName()); // Send Filename
    pw.println(file.length()); // Send filesize
    pw.flush();

    int count;
    while ((count = fis.read(bytes)) > 0) {
      bos.write(bytes, 0, count);
    }
    bos.flush();
    fis.close();
  }catch(IOException e){
    e.printStackTrace();
  }
}