class CreateUser extends AsyncTask<String, String, String> {

    private static final String LOGIN_URL =  "http://localhost/webservice/register.php";
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";

    boolean failure = false;
    String username, password;

    ...
}