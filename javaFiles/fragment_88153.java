public void writeTo(OutputStream outputStream) throws IOException
{
    byte[] buf = createByteBufferFromFile(StorageManager.getFileFromName(context, gId.toString()));
    outputStream.write(buf);
    outputStream.flush();
}