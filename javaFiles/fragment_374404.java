// Interface definition for your async operation here
public interface AsyncOperator {

    @Async
    void launchAsync(String aBody);
}