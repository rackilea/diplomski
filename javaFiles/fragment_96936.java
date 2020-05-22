public class MyServletOutputStream extends ServletOutputStream
{
    private final ServletOutputStream src;

    private final StringBuilder stb=new StringBuilder(4096);

    public MyServletOutputStream(ServletOutputStream src)
    {
        super();
        this.src=src;
    }

    @Override
    public void write(int b)
        throws IOException
    {
        this.src.write(b);
        this.stb.append((char)b);
    }

    public StringBuilder getStb()
    {
        return this.stb;
    }
}