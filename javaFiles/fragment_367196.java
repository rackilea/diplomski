@FormUrlEncoded
@POST("/oauth/access_token")
void getToken(
    @FieldMap Map<String, String> params, 
    Callback<FacebookLoginUserResponse> callback
);