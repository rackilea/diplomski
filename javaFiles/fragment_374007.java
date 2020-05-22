public interface InputStreamAction
{
    void useStream(InputStream stream) throws IOException;
}

// Somewhere else    

public void executeWithFile(String filename, InputStreamAction action)
    throws IOException
{
    InputStream stream = new FileInputStream(filename);
    try {
        action.useStream(stream);
    } finally {
        stream.close();
    }
}

// Calling it
executeWithFile("filename.txt", new InputStreamAction()
{
    public void useStream(InputStream stream) throws IOException
    {
        // Code to use the stream goes here
    }
});

// Calling it with Java 8 Lambda Expression:
executeWithFile("filename.txt", s -> System.out.println(s.read()));

// Or with Java 8 Method reference:
executeWithFile("filename.txt", ClassName::methodName);