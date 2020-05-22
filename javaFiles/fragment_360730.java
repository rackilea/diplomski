final File file = null; // get file somehow
    final DataInputStream dis = new DataInputStream(
      new BufferedInputStream(new FileInputStream(file), 8192));
    try {
        int x;
        while((x = dis.readInt()) != -1) { 
           int y = dis.readInt();
           double value = dis.readDouble();
           // store x,y, value in matrix
        } 
    } finally {
       dis.close();
    }