List<CoreMap> sentences = document.get(SentencesAnnotation.class);
    List<Sentence> convertedSentences = new ArrayList<> ();
    for (CoreMap sentence : sentences)
    {
        int sentenceOffsetStart = sentence.get (CharacterOffsetBeginAnnotation.class);
        if (sentenceOffsetStart > 1 && text.substring (sentenceOffsetStart - 2, sentenceOffsetStart).equals("\n\n") && !convertedSentences.isEmpty ())
        {
            Paragraph current = new Paragraph (convertedSentences);
            paragraphs.add (current);
            convertedSentences = new ArrayList<> ();
        }           
        convertedSentences.add (new Sentence (sentence));
    }
    Paragraph current = new Paragraph (convertedSentences);
    paragraphs.add (current);