Retrofit retrofit = new Retrofit.Builder()
    .baseUrl("https://localpro.herokuapp.com/api/")
    .addConverterFactory(GsonConverterFactory.create())
    .build();

public interface ExampleApi {
@GET("test/drink/")
Call<Example> getExample();