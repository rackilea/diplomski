public void saveIncremental(OutputStream output) throws IOException
{
    InputStream input = new RandomAccessBufferedFileInputStream(incrementalFile);
    COSWriter writer = null;
    try
    {
        writer = new COSWriter(output, input);
        writer.write(this, signInterface);
        writer.close();
    }
    finally
    {
        if (writer != null)
        {
            writer.close();
        }
    }
}