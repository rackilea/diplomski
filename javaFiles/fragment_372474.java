@Override
protected Query getWildcardQuery (String field, String termStr) throws ParseException
{
    String term = termStr;
    TokenStream stream = null;
    try
    {
        // we want only a single token and we don't want to lose special characters
        stream = new KeywordTokenizer (new StringReader (term));

        stream = new LowerCaseFilter (Version.LUCENE_45, stream);
        stream = new ASCIIFoldingFilter (stream);

        CharTermAttribute charTermAttribute = stream.addAttribute (CharTermAttribute.class);

        stream.reset ();
        while (stream.incrementToken ())
        {
            term = charTermAttribute.toString ();
        }
    }
    catch (IOException e)
    {
        LOGGER.debug ("Failed to filter search query token {}", term, e);
    }
    finally
    {
        IOUtils.closeQuietly (stream);
    }
    return super.getWildcardQuery (field, term);
}