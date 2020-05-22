for (CoreMap sentence : doc.get(CoreAnnotations.SentencesAnnotation.class)) { 
    List<CoreLabel> tokens = sentence.get(TokensAnnotation.class);
    for(int i = 0; i < tokens.size() - 3; i++) {
        String pos = tokens.get(i).get(PartOfSpeechAnnotation.class);
        if(pos.equals("NN") || pos.equals("NNS")) {
            pos = tokens.get(i + 1).getString(PartOfSpeechAnnotation.class);
            if(pos.equals("IN")) {
                pos = tokens.get(i + 2).getString(PartOfSpeechAnnotation.class);
                if(pos.equals("DT")) {
                    pos = tokens.get(i + 3).getString(PartOfSpeechAnnotation.class);
                    if(pos.contains("NN")) {
                        //We have a match starting at index i and ending at index i + 3
                        String word1 = tokens.get(i).getString(TextAnnotation.class);
                        String word2 = tokens.get(i + 1).getString(TextAnnotation.class);
                        String word3 = tokens.get(i + 2).getString(TextAnnotation.class);
                        String word4 = tokens.get(i + 3).getString(TextAnnotation.class);
                        System.out.println(word1 + " " + word2 + " " + word3 + " " + word4);
                    }
                }
            }
        }
    }   
}