public interface UiElement<T>
{
    T getSource();
    Class<T> getType();
    // redundant - refer to source
    // Long getId();
    String getName();
    String getDescription();
    Integer getAmount();
    Date getDate();
    Boolean getComplete();
    // redundant - not needed anymore
    // ArticleTemplate getTemplate();
    // redundant - replaced by getType()
    // Boolean getTemplateSimulation(); 
    Integer getRunningTally();
}