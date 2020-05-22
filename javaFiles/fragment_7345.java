public class Book {
    private String id;
    private String name;
    private String original;
    private ArrayList<Author> authors;
    private ArrayList<Translator> translators;
    private Series series;
    private Float no;
    private String seriesNo;
    private Integer published;
    private Borrower borrower;
    private Boolean isCollection;
    private Status status;

    public Book() {}

    public Book(String id, String name, String original, ArrayList<Author> authors, ArrayList<Translator> translators, Series series, Float no, String seriesNo, Integer published, Borrower borrower, Boolean isCollection, Status status) {
        this.id = id;
        this.name = name;
        this.original = original;
        this.authors = authors;
        this.translators = translators;
        this.series = series;
        this.no = no;
        this.seriesNo = seriesNo;
        this.published = published;
        this.borrower = borrower;
        this.isCollection = isCollection;
        this.status = status;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getOriginal() { return original; }
    public ArrayList<Author> getAuthors() { return authors; }
    public ArrayList<Translator> getTranslators() { return translators; }
    public Series getSeries() { return series; }
    public Float getNo() { return no; }
    public String getSeriesNo() { return seriesNo; }
    public Integer getPublished() { return published; }
    public Borrower getBorrower() { return borrower; }
    public Boolean getCollection() { return isCollection; }
    public Status getStatus() { return status; }
}