interface IService {

    @POST("/")
    Call<String> post(
            @Body User user
    );

}