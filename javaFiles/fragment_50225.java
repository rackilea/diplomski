public class ReadElementsWithSameName {

public interface Article {

    @XBRead("./@article-type")
    String getType();

    @XBRead("./front/article-meta/abstract")
    List<String> getAllAbstracts();

    @XBRead("./front/article-meta/abstract[@abstract-type='summary']")
    String getSummary();

}

 // Configure the underlying document builder to not load the (nonexisting) DTD
 private static final XMLFactoriesConfig nonValidatingConfig = new DefaultXMLFactoriesConfig() {
    @Override
    public DocumentBuilderFactory createDocumentBuilderFactory() {
        DocumentBuilderFactory factory = super.createDocumentBuilderFactory();
        try {
            factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
        return factory;
    }
};

public static void main(String... args) throws IOException {
    List<Article> articles = new XBProjector(nonValidatingConfig).io().url("res://data.xml").evalXPath("/article").asListOf(Article.class);
    for (Article article:articles) {
        System.out.println(article.getType());
        System.out.println(article.getSummary());
        System.out.println(article.getAllAbstracts());
    }
  }
}