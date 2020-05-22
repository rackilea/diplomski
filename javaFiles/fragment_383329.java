private boolean saveFile(String fileName, URL download)
{
    try
    {          
        String saveTo = System.getProperty("user.dir") + "\\Applications\\Setup\\";

        ReadableByteChannel rbc = Channels.newChannel(download.openStream());

        FileOutputStream fos = new FileOutputStream(saveTo + fileName);

        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);

        fos.close();

        return true;
    }
    catch (FileNotFoundException e)
    {
        e.printStackTrace();
    }
    catch (MalformedURLException e)
    {
        e.printStackTrace();
    }
    catch (IOException e)
    {
        e.printStackTrace();
    }
    return false;
}