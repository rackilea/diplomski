interface CustomService {
    @GET("whatever")
    Call<Response<Void>> getAll();

    // Or using RxJava:
    @GET("whatever")
    Single<Response<Void>> getRxAll();
}