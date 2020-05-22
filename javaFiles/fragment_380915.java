Blob blob = rs.getBlob("BLOB_COLUMN_NAME");        
    InputStream blobStream = blob.getBinaryStream();

    //e.g. save blob to a file
    FileOutputStream out = new FileOutputStream("file.txt");
    byte[] buffer = new byte[1024];
    int n = 0;  
    while( (n = blobStream.read(buffer)) != -1 ) {
        out.write(buffer, 0, n);
    }
    out.flush();
    out.close();
    blobStream.close();