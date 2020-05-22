public class Article {

    private int cod;
    private String name;
    private static int counter = 10;

    public Article(String name) {
        this.name = name;
        this.cod = counter;
        counter += 10;
    }

}