@XStreamAlias("Book")
class Book {

    @XStreamAlias("author")
    String author;

    @XStreamAlias("title")
    String title;

    public static void main(String[] args) {
        String input = "<Book>"
                + "<author>ABC</author>"
                + "<title>XYZ</title>"
                + "<pages>50</pages>"
                + "</Book>";

        XStream xStream = new XStream();
        xStream.ignoreUnknownElements();
        xStream.processAnnotations(Book.class);

        Book book = (Book) xStream.fromXML(input);
    }
}