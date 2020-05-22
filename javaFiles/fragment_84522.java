// First collect all values and compute min/max on the fly
double minValue=Double.MAX_VALUE;
double maxValue=-Double.MAX_VALUE;
double values = new String[termsDocsArray.size()][allTerms.size()];
int c=0; //for files
for (String[] docTermsArray : termsDocsArray) {
    int count = 0;//for words
    for (String terms : allTerms) {
        double tf = new TfIdf().tfCalculator(docTermsArray, terms);
        double idf = new TfIdf().idfCalculator(termsDocsArray, terms);
        double tfidf = tf * idf;           
        tfidf = Math.round(tfidf*10000)/10000.0d;
        minValue = Math.min(minValue, tfidf);
        maxValue = Math.max(maxValue, tfidf);
        values[c][count]=tfidf;
        count++;   
    }     
    c++;
}

// Then, create the matrix containing the strings of the normalized 
// values (although using strings here seems like a bad idea)
c=0; //for files
for (String[] docTermsArray : termsDocsArray) {
    int count = 0;//for words
    for (String terms : allTerms) {
        double tfidf = values[c][count];
        tfidf=(tfidf-minValue)/(maxValue-minValue);  //Normalization here
        mat[c][count]=Double.toString(tfidf);
        count++;   
    }     
    c++;
}