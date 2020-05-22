public class ArticleUiElement implements UiElement<Article>
{
    private Article source;
    private Integer tally;

    public ArticleUiElement(Article source) {
        this.source = source;
    }

    public Article getSource() {
        return source;
    }

    public Class<Article> getType() {
        return Article.class;
    }

    public String getName() {
        return source.getName();
    }

    public String getDescription() {
        return source.getDescription();
    }

    public Integer getAmount() {
        return source.getAmount();
    }

    public Date getDate() {
        return source.getDate();
    }

    public Boolean getComplete() {
        return source.getComplete();
    }

    public String getRunningTally() {
        return tally;
    }

    public void setRunningTally(String tally) {
        this.tally = tally;
    }
}