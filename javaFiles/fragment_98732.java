private class DataHelper {

   public DataHelper(String word, String meaning, String sentence) {
        this.word.setValue(word);
        this.meaning.setValue(meaning);
        this.sentence.setValue(sentence);
    }

   StringProperty word = new SimpleStringProperty();
   StringProperty meaning = new SimpleStringProperty();
   StringProperty sentence = new SimpleStringProperty();
   // setters and getters
}