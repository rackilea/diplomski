public class Parrot {

    private Language language;

    @Inject
    public Parrot(Language language) {
        this.language = language;
    }

    public void sayHello() {
        System.out.println(language.getSalute());
    }
}

public interface Language {
    public String getSalute();
}

public class EnglishLanguage implements Language {

    @Override
    public String getSalute() {
        return "Hello!";
    }
}