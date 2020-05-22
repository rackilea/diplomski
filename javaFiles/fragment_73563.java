class FakeScanner
{
    private int linesLeft;
    private final String line;

    public FakeScanner(String line, int count)
    {
        linesLeft = count;
        this.line = line;
    }

    public boolean hasNext()
    {
        return linesLeft > 0;
    }

    public String next()
    {
        linesLeft--;
        return line;
    }
}

public class Test
{    
    public static void main(String[] args)
    {
        FakeScanner scanner = new FakeScanner("test", 30000);

        boolean useStringBuilder = "fast".equals(args[0]);

        // Accurate enough for this test
        long start = System.currentTimeMillis();

        String someString;
        if (useStringBuilder)
        {
            StringBuilder builder = new StringBuilder();
            while (scanner.hasNext())
            {
                builder.append(scanner.next());
            }
            someString = builder.toString();
        }
        else
        {
            someString = "";     
            while (scanner.hasNext())
            {
                someString += scanner.next();
            }        
        }
        long end = System.currentTimeMillis();

        System.out.println("Building a string of length " 
                           + someString.length()
                           + (useStringBuilder ? " with" : " without")
                           + " StringBuilder took " + (end - start) + "ms");
    }
}