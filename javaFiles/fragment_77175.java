public interface RestApiService {

  @GET("/photos")
  public Call<List<Blog2>> getPopularBlog();

}