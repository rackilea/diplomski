import org.apache.lucene.analysis.PorterStemmer;
...
String stemTerm (String term) {
    PorterStemmer stemmer = new PorterStemmer();
    return stemmer.stem(term);
}