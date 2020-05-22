public class Capture extends PrintStream
{

    private StringBuilder m_build;

    public Capture(OutputStream out, StringBuilder build)
    {
        super(out);

        m_build = build;
    }

    public void println(String s)
    {
        super.println(s);

        m_build.append(s + "\n");
    }

}