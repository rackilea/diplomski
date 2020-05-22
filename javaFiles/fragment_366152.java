class Publisher {
    private String pubName;
    public Publisher(Publisher other) { // ***
        this.pubName = other.pubName;   // ***
    }                                   // ***
    //10-15 other members here
    public String getPublisher(){
        return pubName;
    }
    public void setName(String name){
        pubName = name;
    }
}

class Author extends Publisher{
    private String authorName;
    public Author(Publisher pub) {      // ***
        super(pub);                     // ***
    }                                   // ***
    //5-10 other members here
    public String getAuthor(){
        return authorName;
    }
    @Override
    public void setName(String name){
        authorName = name;
    }
}