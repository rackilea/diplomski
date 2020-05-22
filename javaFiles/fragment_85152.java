public OtherClass {

    private Article article;

    public OtherClass(Article data) {
        article = data;
    }

    public String getArticleContents() {

        return (new StringBuilder())
        .append(article.getTitle())
        .append(article.getCategory())
        .append(dateToString(article.getPubDate())
        .append(article.getBody())
        .toString();
    }
}