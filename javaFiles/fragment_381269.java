public interface ApiService {

    @POST( "let/fmir" )
    @Headers( {
            "Accept-Encoding: gzip,deflate",
            "Content-Type: Application/Json;charset=UTF-8",
            "Accept: Application/Json",
            "User-Agent: Retrofit 2.3.0"
    } )
    Call<LetPOJO> fmir(
            @Header( "Authorization" ) String authorization,
            @Body List<String> body
    );
}

...

ApiService apiService = ApiServiceProvider.createApiService();
Call<LetPOJO> call = apiService.fmir(
    "Basic NDUhg4234OQ==",
    Arrays.asList("L___1", "L___2", "L___3", "L___4")
);