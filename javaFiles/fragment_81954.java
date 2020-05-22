int fileLength = (int) file.length();
    byte[] buffer = new byte[fileLength < FILE_UPLOAD_CHUNK_SIZE ?
            fileLength : FILE_UPLOAD_CHUNK_SIZE];
    int bytesRead;
    int readTotal = 0;
    BufferedInputStream inStream = null;
    try
    {
        inStream = new BufferedInputStream(new FileInputStream(file));
        do
        {
            bytesRead = inStream.read(buffer, 0, buffer.length);
            if (bytesRead == -1)
            {
                continue;
            }
            byte[] finalBuffer;
            if (buffer.length > bytesRead)
            {
                finalBuffer = Arrays.copyOf(buffer, bytesRead);
            }
            else
            {
                finalBuffer = buffer;
            }
            uploadChunk(
                    finalBuffer,
                    mimeType,
                    uploadPath,
                    fileLength,
                    readTotal,
                    readTotal + bytesRead - 1);
            readTotal += bytesRead;
        } while (bytesRead != -1);
    }
    finally
    {
        if (inStream != null)
        {
            inStream.close();
        }
    }