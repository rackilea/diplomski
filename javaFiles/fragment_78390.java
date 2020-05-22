public class UploadStream extends FilterOutputStream {

final ProgressListener listener;
private long transferred;

public UploadStream(final OutputStream out, final ProgressListener listener)
{
    super(out);
    this.listener = listener;
    this.transferred = 0;
}

public void write(byte[] b, int off, int len) throws IOException
{
    out.write(b, off, len);
    this.transferred += len;
    System.out.println(this.transferred/1024+" KB");
}

public void write(int b) throws IOException
{
    out.write(b);
    this.transferred++;
}

}