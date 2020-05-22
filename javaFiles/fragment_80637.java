public class DownloadToFile
{
    private URL from;
    private String to;

    public DownloadToFile(URL url, String path_to)
    {
        this.URL = url;
        this.to = path_to;
    }

    public DownloadToFile(String url, String path_to)
    {
        try
        {
            this.URL = new URL(url);
        }
        catch(MalformedURLException e)
        {
            e.printStackTrace();
        }

        this.to = path_to;
    }

    public void saveFile() throws IOException 
    {
        BufferedInputStream in = new BufferedInputStream(this.from.openStream());
        FileOutputStream out = new FileOutputStream(this.to);
            try 
            {
                final byte data[] = new byte[1024];
                    int count;
                        while ((count = in.read(data, 0, 1024)) != -1)
                        {
                            out.write(data, 0, count);
                        }
            }
            finally
            {
                if (in != null)
                {
                    in.close();
                }
        if (fout != null)
        {
            fout.close();
        }
    }
}