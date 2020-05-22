public class StandardFilter extends TokenFilter {
  public StandardFilter(TokenStream in) {
    super(in);
  }

  @Override
  public final boolean incrementToken() throws IOException {
    return input.incrementToken(); // TODO: add some niceties for the new grammar
  }
}