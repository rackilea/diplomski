public class CallableParser extends CGrammarParser implements Callable<CGrammarParser.CSnippetContext>
{
    public CallableParser(TokenStream input)
    {
        super(input);
    }

    @Override
    public CGrammarParser.CSnippetContext call()
    {
        return cSnippet();
    }
}