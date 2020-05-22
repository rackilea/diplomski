public class SomeClass{
    private String api;

    @Inject
    SomeClass(@Named("api") String api) {
        this.api = api;
    }

    public Observable<String> get(String uuidData){
        //do something with "api" variable
    }
}