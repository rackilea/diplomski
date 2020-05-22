public final class StandardAnalyzerV36 extends Analyzer {

    public static final CharArraySet STOP_WORDS_SET = StopAnalyzer.ENGLISH_STOP_WORDS_SET;  

    @Override
    protected TokenStreamComponents createComponents(String fieldName) {

        final ClassicTokenizer src = new ClassicTokenizer();
        TokenStream tok = new StandardFilter(src);
        tok = new StopFilter(new LowerCaseFilter(tok), STOP_WORDS_SET);

        return new TokenStreamComponents(src, tok);
    }

    @Override
    protected Reader initReader(String fieldName, Reader reader) {
        return new HTMLStripCharFilter(reader);
    }
}

public class LuceneUtils {

    public static List<String> tokenizeString(Analyzer analyzer, String string) {
        List<String> result = new ArrayList<String>();
        TokenStream stream = null;
        try {
            stream = analyzer.tokenStream(null, new StringReader(string));
            stream.reset();
            while (stream.incrementToken()) {
                result.add(stream.getAttribute(CharTermAttribute.class).toString());
            }
        } catch (IOException e) {
            // not thrown b/c we're using a string reader...
            throw new RuntimeException(e);
        } finally {
            IOUtils.closeQuietly(stream);
        }
        return result;
    }
}