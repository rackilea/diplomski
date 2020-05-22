RandomAccessFile racFile = new RandomAccessFile(file, "r");
   FileChannel ch = racFile.getChannel( );
   ch.transferTo(0,  fileLength, new WritableByteChannel(){

    @Override
    public boolean isOpen() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public void close() throws IOException {
        // TODO Auto-generated method stub

    }

    @Override
    public int write(ByteBuffer src) throws IOException {
        // TODO Auto-generated method stub
        int rem = src.remaining();
        return rem;
    }

   }

   );
   racFile.close();