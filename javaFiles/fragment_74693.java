public static void main(String[] args) throws IOException {
    System.out.println("\n----");
    System.out.println("StandardAnalyzer");
    displayTokensWithFullDetails(new StandardAnalyzer(Version.LUCENE_43),
        "I'll email you at xyz@example.com");
}

public static void displayTokensWithFullDetails(Analyzer analyzer,
                                                  String text) throws IOException {

    TokenStream stream = analyzer.tokenStream("contents",
                                              new StringReader(text));

    stream.reset(); //Add this line removes NullPointerException

    //defining attributes

    while(stream.incrementToken()) {

      //print details of tokens

    }
    System.out.println();
  }