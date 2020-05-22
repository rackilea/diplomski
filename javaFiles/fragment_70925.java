public class Quotes {

    private String file;
    private String use;
    private List<Phrases> famous_phrases;

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public List<Phrases> getFamous_phrases() {
        return famous_phrases;
    }

    public void setFamous_phrases(List<Phrases> famous_phrases) {
        this.famous_phrases = famous_phrases;
    }

}

public class Phrases {

    private String phrase1;
    private String phrase2;
    private String id;

    public String getPhrase1() {
        return phrase1;
    }

    public void setPhrase1(String phrase1) {
        this.phrase1 = phrase1;
    }

    public String getPhrase2() {
        return phrase2;
    }

    public void setPhrase2(String phrase2) {
        this.phrase2 = phrase2;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}