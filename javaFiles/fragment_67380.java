InputStream pdfSource = connection.getInputStream();
    OutputStream pdfTarget = response.getOutputStream();

    int FILE_CHUNK_SIZE = 1024 * 4;
    byte[] chunk = new byte[FILE_CHUNK_SIZE]; 
    int n =0;
    while ( (n = pdfSource.read(chunk)) != -1 ) {
        pdfTarget.write(chunk, 0, n);
    }
} // End of if