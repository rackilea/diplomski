package com.ggl.testing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public enum PartsOfSpeech {
    ADJECTIVE, ADVERB, ARTICLE, CONJUNCTION, INTERJECTION, NOUN,              
    PREPOSITION, PRONOUN, VERB
}

class Word {

    private final PartsOfSpeech partOfSpeech;

    private final String word;

    public Word(PartsOfSpeech partOfSpeech, String word) {
        this.partOfSpeech = partOfSpeech;
        this.word = word;
    }

    public PartsOfSpeech getPartOfSpeech() {
        return partOfSpeech;
    }

    public String getWord() {
        return word;
    }

}

class Sentence {

    private List<Word> words;

    private Random random;

    public Sentence() {
        this.words = createWordList();
        this.random = new Random();
    }

    private List<Word> createWordList() {
        List<Word> words = new ArrayList<Word>();
        words.add(new Word(PartsOfSpeech.VERB, "run"));
        // add the rest of the words here

        return words;
    }

    public Word getWord(PartsOfSpeech partsOfSpeech) {
        List<Word> subList = getSubList(partsOfSpeech);
        int index = random.nextInt(subList.size());
        return subList.get(index);
    }

    private List<Word> getSubList(PartsOfSpeech partsOfSpeech) {
        List<Word> subList = new ArrayList<Word>();
        for (Word word : words) {
            if (word.getPartOfSpeech() == partsOfSpeech) {
                subList.add(word);
            }
        }

        return subList;
    }

}