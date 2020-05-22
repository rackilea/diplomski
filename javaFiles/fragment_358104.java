public class Recipe {

    private EvaUser author;
    private String name = "test";
    private String ingridients = "carrots, tomatos";

    public EvaUser getAuthor() {
        return author;
    }

    public void setAuthor(EvaUser author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngridients() {
        return ingridients;
    }

    public void setIngridients(String ingridients) {
        this.ingridients = ingridients;
    }
}