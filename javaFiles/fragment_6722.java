for(ScoreDoc ScoreDoc: scoreDocs){
TermFreqVector[] termsV = reader.getTermFreqVectors(ScoreDoc.doc);
            int termFreq = 0;
            for (int xy = 0; xy < termsV.length; xy++) {  
                String[] terms = termsV[xy].getTerms(); 
                int[] termFreqs = termsV[xy].getTermFrequencies();
                int termcount = 0;
                int count=0;
                for(String str : terms){
                    if(str.equalsIgnoreCase(queryString)){
                        termcount = count;
                    }
                    count++;
                }
                termFreq = termFreqs[termcount];
            }
}