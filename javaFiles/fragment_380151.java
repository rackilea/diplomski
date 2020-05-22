AssetManager assetManager = context.getAssets();

InputStream is = null;
OutputStream os = null;
try
{
    is = assetManager.open("my_file");
    os = new FileOutputStream("/system/bin/my_file");

    byte[] buffer = new byte[1024];
    int length;

    // copy the file content in bytes 
    while ((length = is.read(buffer)) > 0)
    {
        os.write(buffer, 0, length);
    }
}
catch (Exception e)
{
    // Dealing with the exception, log or something
}
finally
{
    if (is != null) try { is.close(); } catch (IOException e) {}
    if (os != null) try { os.close(); } catch (IOException e) {}
}