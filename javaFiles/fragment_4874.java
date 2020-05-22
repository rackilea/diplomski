public class NetworkCallsRetrofitImpl implements NetworkCallsApi{

    private final Retrofit retrofit;

    public NetworkCallsRetrofitImpl() {
        retrofit = new Retrofit.Builder()
            .baseUrl(StringConstants.ROOT_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    }

    public void getDataFromServer(String url, Callback<ResponseBody> cb) {
        retrofit.create(RetrofitApi.class)
            .getDataFromServer(url)
            .enqueue(cb);
    }
}