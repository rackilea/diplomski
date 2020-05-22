public class BalanceRestClient {

            private static BalanceRestClient instance;
            private IBalanceService request;

            private BalanceRestClient() {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://hovermind.com")
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(rxAdapter)
                        .build();

                request = retrofit.create(IBalanceService.class);
            }

            public static synchronized BalanceRestClient getInstance() {
                if (instance == null)
                    instance = new BalanceRestClient();

                return instance;
            }

            public void getRequest(String userName, YourCustomeCallback callback) {

                Call<User> call = apiService.getUser(username);
                call.enqueue(new Callback<User>() {

                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {

                        User user = response.body();

                        callback.onResponse(user);

                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        // Log error here since request failed
                    }

                });
            }
        }