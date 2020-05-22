public interface SafeUserApi {
 @FormUrlEncoded
    @POST("/api/userlogin")
    void getUserLogin(
            @Field("client_id") String id,
            @Field("client_secret") String secret,
            @Field("username") String uname,
            @Field("password") String password,
            Callback<LoginResult> cb
    );
}