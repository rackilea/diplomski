public MainActivity extends Activity {

    public void onCreate() {
        super.onCreate();
        ApiClient client = new ApiClient();
        client.login(new LoginCallback() {
            @Override
            public void ready() {
            //... do your next request in the API.
            }
        });
    }    
}