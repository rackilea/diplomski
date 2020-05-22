public static Bitmap loadBitmap(String url) throws IOException
{
    final InputStream in = new BufferedInputStream(new URL(url).openStream(),  4 * 1024);

    try 
    {
        final ByteArrayOutputStream dataStream = new ByteArrayOutputStream();
        final BufferedOutputStream out = new BufferedOutputStream(dataStream,  4 * 1024);

        try
        {
            int byte_;
            while ((byte_ = in.read()) != -1)
                out.write(byte_);
            out.flush();

            final byte[] data = dataStream.toByteArray();
            BitmapFactory.Options options = new BitmapFactory.Options();
            //options.inSampleSize = 1;

            return BitmapFactory.decodeByteArray(data, 0, data.length,options);
        }
        finally
        {
            out.close();
        }
    } 
    finally 
    {
        in.close();
    }
}