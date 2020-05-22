public abstract class Word {

    private final String english, german, french;

    protected Word(String english, String german, String french) {
        this.english = english;
        this.german = german;
        this.french = french;
    }

    public String translateTo(Language language) throws Exception {
        switch(language) {
        case English:   return english;
        case German:    return german;
        case French:    return french;
        }
        throw new Exception();      //you can write a LanguageNotFoundException
    }
}