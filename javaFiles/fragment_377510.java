public class CaptureWriter extends Writer
{

    private StringBuilder m_build;

    public CaptureWriter(StringBuilder build)
    {
        m_build = build;
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException
    {
        m_build.insert(m_build.length(), cbuf, off, len);
    }

    @Override
    public void flush() throws IOException
    {
    }

    @Override
    public void close() throws IOException
    {
    }

}