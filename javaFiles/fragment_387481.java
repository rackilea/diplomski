@retrofit2.http.POST("{serverext}")
@FormUrlEncoded
Call<LoginResponseModel> loginUser(@retrofit2.http.Path(value = "serverext", encoded = true) String server,
                             @retrofit2.http.Field(Constants.USER) String username,
                             @retrofit2.http.Field(Constants.PASS) String password,
                             @retrofit2.http.Query("timestamp") Long timestamp, 
                             @retrofit2.http.Query("action") String action);

loginUser("mdc.php", username, pass, 42, "login_user")