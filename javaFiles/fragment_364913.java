public interface MyApi {

    @GET("/endpoint")
    public Single<Result> doSomething();

}