public abstract class MyAbstractTask<T> extends AsyncTask<String, String, T>{
    int success;
    protected Context context;
    protected MyAbstractListener listener;
    protected String userToBeDeleted;
    protected  JSONParser jsonParser = new JSONParser();
    protected static final String TAG_SUCCESS = "success";
    protected static final String TAG_DELETION_FAILURE_CONNECTION_ERROR = "Connection Error"; 

    public MyAbstractTask(Context context, MyAbstractListener listener){
        this.context = context;
        this.listener = listener;
    }


    @Override
    protected void onPreExecute() {
        ShowLoadingMessage.loading(context);
        super.onPreExecute();
    }

   ...
}


public class DeleteUser extends MyAbstractTask<String> {
    private String userToBeDeleted;
    private static final String TAG_DELETION_SUCCESS = "Deletion Success";
    private static final String TAG_DELETION_FAILURE_ACCOUNT_NOT_DELETED = "Account Not Deleted";

    public DeleteUser(Context context, OnUserDeletionListener listener, String userToBeDeleted) {
       super(context, listener);
        this.userToBeDeleted = userToBeDeleted;
    }

    @Override
    protected String doInBackground(String... args) {
        int success;

            try {
                List<NameValuePair> deleteUserAccount = new ArrayList<NameValuePair>();

                deleteUserAccount.add(new BasicNameValuePair("user_id", userToBeDeleted));

                JSONObject json = jsonParser.makeHttpRequest(Configurationz.URLs.PHP_DELETE_USER_ACCOUNT, "POST", deleteUserAccount);

                success = json.getInt(TAG_SUCCESS);

                if (success == 1) {
                    return "Deletion Success";
                } else if (success == 2) {
                    return "Account Not Deleted";

                } else {
                    return "Connection Error";
                }
            } catch (JSONException e) {
                e.printStackTrace();
                return "Connection Error";
            }
    }

    @Override
    protected void onPostExecute(String result) {
        ShowLoadingMessage.dismissDialog();
        if(listener != null) {
            if (result.contentEquals(TAG_DELETION_SUCCESS)) {
                listener.onUserDeletionSuccess();
            } else if(result.contentEquals(TAG_DELETION_FAILURE_ACCOUNT_NOT_DELETED)) {
                listener.onUserDeletionFailure(result);
            } else if(result.contentEquals(TAG_DELETION_FAILURE_CONNECTION_ERROR)) {    
                listener.onUserDeletionFailure(result); 
            }
        }
        super.onPostExecute(result);
    }
}