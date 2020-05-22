public class SymbolSplitterFilterTest extends BaseTokenStreamTestCase {


@Test
public void testSomeMethod() throws IOException
{
    Analyzer analyzer = this.getAnalyzer();
    assertAnalyzesTo(analyzer, "hey xyz@example.com",
        new String[]{"hey", "xyz@example.com", "example.com", "xyz"},
        new int[]{0, 4, 4, 4},
        new int[]{3, 19, 19, 19},
        new String[]{"word", "word", "word", "word"},
        new int[]{1, 1, 0, 0}
        );
}

 private Analyzer getAnalyzer()
{
    return new Analyzer()
    {
        @Override
        protected Analyzer.TokenStreamComponents createComponents(String fieldName)
        {
            Tokenizer tokenizer = new MockTokenizer(MockTokenizer.WHITESPACE, false);
            SymbolSplitterFilter testFilter = new SymbolSplitterFilter(tokenizer);
            return new Analyzer.TokenStreamComponents(tokenizer, testFilter);
        }
    };
}

}