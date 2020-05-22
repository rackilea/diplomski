// Need to be a bean managed by Spring to be async
@Component
class SimpleAsync implements AsyncOperator {
    @Override
    public void launchAsync(String aBody){
        // Your async operations here
    }
}