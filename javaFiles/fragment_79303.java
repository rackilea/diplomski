public class ArticleTemplateUiElement implements UiElement<ArticleTemplate>
{
    private ArticleTemplate source;
    private Integer tally;
    private Date date;

    public ArticleTemplateUiElement(ArticleTemplate source) {
        this.source = source;
    }

    public ArticleTemplate getSource() {
        return source;
    }

    public Class<ArticleTemplate> getType() {
        return ArticleTemplate.class;
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
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getComplete() {
        return false;
    }

    public String getRunningTally() {
        return tally;
    }

    public void setRunningTally(String tally) {
        this.tally = tally;
    }
}