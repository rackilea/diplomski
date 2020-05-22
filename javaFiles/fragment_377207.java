public interface Api {
  String BASE_URL = "URL";
  @GET("PathtoUrlFunction")
  Call<Result>getResult(@Query("uid") 
  String myUID, @Query("amount") String 
  amount);
}