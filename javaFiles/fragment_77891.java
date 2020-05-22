public interface IArgumentParser
{
    Configuration Parse(string[] arguments);
}

public static class ArgumentParsers
{
    public static IArgumentParser(string file)
    {
        return new FileArgumentParser(file);
    }
}

internal class FileArgumentParser : IArgumentParser
{
    private readonly string file;

    internal FileArgumentParser(string file)
    {
        this.file = file;
    }

    public Configuration Parse(string[] arguments)
    {
        // Presumably use the file somewhere...
    }
}