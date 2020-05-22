public static double cosineSimForSentence(Word2Vec vector, String sentence1, String sentence2){
        Collection<String> label1 = Splitter.on(' ').splitToList(sentence1);
        Collection<String> label2 = Splitter.on(' ').splitToList(sentence2);
        try{
            return Transforms.cosineSim(vector.getWordVectorsMean(label1), vector.getWordVectorsMean(label2));
        }catch(Exception e){
            exceptionMessage = e.getMessage();
        }
        return Transforms.cosineSim(vector.getWordVectorsMean(label1), vector.getWordVectorsMean(label2));

    }