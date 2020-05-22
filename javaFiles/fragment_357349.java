public HashMap<Integer, TokenSpan> getTokenSpans(String text, Tree parse)
{
    List<String> tokens = new ArrayList<String>();
    traverse(tokens, parse, parse.getChildrenAsList());
    return extractTokenSpans(text, tokens);
}

private void traverse(List<String> tokens, Tree parse, List<Tree> children)
{
    if(children == null)
        return;
    for(Tree child:children)
    {
        if(child.isLeaf())
        {
            tokens.add(child.value());
        }
        traverse(tokens, parse, child.getChildrenAsList());         
    }
}

private HashMap<Integer, TokenSpan> extractTokenSpans(String text, List<String> tokens)
{
    HashMap<Integer, TokenSpan> result = new HashMap<Integer, TokenSpan>();
    int spanStart, spanEnd;

    int actCharIndex = 0;
    int actTokenIndex = 0;
    char actChar;
    while(actCharIndex < text.length())
    {
        actChar = text.charAt(actCharIndex);
        if(actChar == ' ')
        {
            actCharIndex++;
        }
        else
        {
            spanStart = actCharIndex;
            String actToken = tokens.get(actTokenIndex);
            int tokenCharIndex = 0;
            while(tokenCharIndex < actToken.length() && text.charAt(actCharIndex) == actToken.charAt(tokenCharIndex))
            {
                tokenCharIndex++;
                actCharIndex++;
            }

            if(tokenCharIndex != actToken.length())
            {
                //TODO: throw exception
            }
            actTokenIndex++;
            spanEnd = actCharIndex;
            result.put(actTokenIndex, new TokenSpan(spanStart, spanEnd));
        }
    }
    return result;
}