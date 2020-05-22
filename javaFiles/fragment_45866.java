int success;
private Context context;
private OnUserDeletionListener listener;
private JSONParser jsonParser = new JSONParser();
private static final String TAG_SUCCESS = "success";
private static final String TAG_DELETION_FAILURE_CONNECTION_ERROR = "Connection Error";