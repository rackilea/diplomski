String foo = "foo:doc1.txt";
    StandardAnalyzer sa = new StandardAnalyzer(Version.LUCENE_34);
    TokenStream tokenStream = sa.tokenStream("foo", new StringReader(foo));
    while (tokenStream.incrementToken()) {
        System.out.println(tokenStream.getAttribute(TermAttribute.class).term());
    }

    System.out.println("-------------");

    KeywordAnalyzer ka = new KeywordAnalyzer();
    TokenStream tokenStream2 = ka.tokenStream("foo", new StringReader(foo));
    while (tokenStream2.incrementToken()) {
        System.out.println(tokenStream2.getAttribute(TermAttribute.class).term());
    }