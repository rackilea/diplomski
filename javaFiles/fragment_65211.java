LetterEntity letter = new LetterEntity();
    PhraseEntity phrase = new PhraseEntity();
    SentenceEntity sentence = new SentenceEntity();

    sentence.getLetters().add(letter);
    s.persist(sentence);
    phrase.getLetters().add(letter);
    s.persist(phrase);