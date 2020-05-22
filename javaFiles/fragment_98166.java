public class EndpointsServer implements Server {

    private static final String TAG = "EndpointsServer";

    final UserModelApi userEndpointsApi;

    public EndpointsServer() {
        UserModelApi.Builder builder = new UserModelApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                    @Override
                    public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                        abstractGoogleClientRequest.setDisableGZipContent(true);
                    }
                });

        userEndpointsApi = builder.build();

    }

    @Override
    public User getUser(String email)  {
        User  user = null;
        try {
            Log.d(TAG, "in getUser with email " +email);
            // get user from db
            UserModel userModel = userEndpointsApi.getUserModel(email).execute();

            if (userModel != null) {
                Log.d(TAG, "user != null with email " + email);
                user = new User(userModel);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    } 
}