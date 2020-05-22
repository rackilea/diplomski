public static void readInputStreamToFile(InputStream is, FileOutputStream fout,
        long size, int bufferSize) throws Exception
{
    byte[] buffer = new byte[bufferSize];
    long curRead = 0;
    long totalRead = 0;
    long sizeToRead = size;
    while(totalRead < sizeToRead)
    {
        if(totalRead + buffer.length <= sizeToRead)
        {
            curRead = is.read(buffer);
        }
        else
        {
            curRead = is.read(buffer, 0, (int)(sizeToRead - totalRead));
        }
        totalRead = totalRead + curRead;
        fout.write(buffer, 0, (int) curRead);
    }
}


public static void writeFileInputStreamToOutputStream(FileInputStream in, OutputStream out, int bufferSize) throws Exception
{
    byte[] buffer = new byte[bufferSize];
    int count = 0;
    while((count = in.read(buffer)) != -1)
    {
        out.write(buffer, 0, count);
    }
}