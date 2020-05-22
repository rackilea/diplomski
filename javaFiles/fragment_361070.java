public final class SymbolSplitterFilter extends TokenFilter {

private final CharTermAttribute termAtt;
private final PositionIncrementAttribute posIncAtt;
private final Stack<String> termStack;
private AttributeSource.State current;
private final TypeAttribute typeAtt;

public SymbolSplitterFilter(TokenStream in)
{
    super(in);
    termStack = new Stack<>();
    termAtt = addAttribute(CharTermAttribute.class);
    posIncAtt = addAttribute(PositionIncrementAttribute.class);
    typeAtt = addAttribute(TypeAttribute.class);
}

@Override
public boolean incrementToken() throws IOException
{
    if (!this.termStack.isEmpty()) {
        String part = termStack.pop();
        restoreState(current);
        termAtt.setEmpty().append(part);
        posIncAtt.setPositionIncrement(0);
        return true;
    } else if (!input.incrementToken()) {
        return false;
    } else {
        final String currentTerm = termAtt.toString();
        final int bufferLength = termAtt.length();

        if (bufferLength > 1 && currentTerm.indexOf("@") > 0) { // There must be sth more than just @
            if (termStack.isEmpty()) {
                termStack.addAll(Arrays.asList(currentTerm.split("@")));
                current = captureState();
            }
        }
        return true;

    }

}
}