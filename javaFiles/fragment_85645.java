public abstract class Programmer {
    private String language;

    public Programmer(String language) {
        this.language = language;
    }

    public void writeCode() {
        System.out.println("Written in " + language);
    }
}