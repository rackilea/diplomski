class FileDetails implements Serializable {
  private static final int CHUNK_LEN = 0x10000; // 64k
  private String fileName;
  private long fileSize;
  private File file;

  // Note: everything can be deduced from a File object
  public FileDetails(File file) {
    this.fileName = file.getName();
    this.fileSize = file.length();       
    this.file = file;
  }

  public String getFileName() {
    return fileName;
  }

  public long getFileSize() {
    return fileSize;
  }

  // explicit coding for reading a FileDetails object
  private void readObject(ObjectInputStream stream)
    throws IOException, ClassNotFoundException {
    fileName = stream.readUTF();  // file name
    fileSize = stream.readLong(); // file size
    // file data as a series of byte[], length CHUNK_LEN
    long toRead = fileSize;
    // write file data to a File object, same path name
    file = new File( fileName );
    OutputStream os = new FileOutputStream( file );
    while( toRead > 0 ){
      // last byte arrays may be shorter than CHUNK_LEN
      int chunkLen = toRead > CHUNK_LEN ? CHUNK_LEN : (int)toRead;
      byte[] bytes = new byte[chunkLen];
      int nread = stream.read( bytes );
      // write data to file
      os.write( bytes, 0, nread );
      toRead -= nread;
    }
    os.close();
  }

  // explicit coding for writing a FileDetails object
  private void writeObject(ObjectOutputStream stream)
    throws IOException {
    stream.writeUTF( fileName );   // file name as an "UTF string"
    stream.writeLong( fileSize );  // file size
    // file data as a series of byte[], length CHUNK_LEN
    long toWrite = fileSize;
    // read file data from the File object passed to the constructor
    InputStream is = new FileInputStream( file );
    while( toWrite > 0 ){
      // last byte[] may be shorter than CHUNK_LEN
      int chunkLen = toWrite > CHUNK_LEN ? CHUNK_LEN : (int)toWrite;
      byte[] bytes = new byte[chunkLen];
      int nread = is.read( bytes );
      stream.write( bytes );
      toWrite -= nread;
    }
    is.close();
  }

  private void readObjectNoData()
    throws ObjectStreamException {
  }
}