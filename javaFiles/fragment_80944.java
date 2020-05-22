public class RetrofitClient {

    private static LoginServices apiService;

    public RetrofitClient(String baseUrl) {

           Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

         apiService = retrofit.create(LoginServices.class);
    }

    public LoginServices getServies(){
        return apiService;
    }
}