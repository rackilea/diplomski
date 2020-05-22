void saveIncremental(OutputStream output, InputStream input, PDDocument document, SignatureInterface signatureInterface) throws IOException
{
    COSWriter writer = null;
    try
    {
        writer = new COSWriter(output, input);
        writer.write(document, signatureInterface);
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