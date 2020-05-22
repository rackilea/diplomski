public class Application extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            String message = "Hello World from Android";
             new requestHandler(this).execute(getActivity(), "IM_Application", message, "sendPublicKey");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        //your returning result
public void onBackgroundTaskCompleted(JSONArray jsonarray) {
        Log.i("TAG", jsonarray:"+jsonarray);

        if(jsonarray!=null){
            //process your jsonarray to get the Globals.PUBLIC_KEY)here

                    Log.v("onBackgroundTaskCompleted", "Public KEY JSON from OnStart" + Globals.PUBLIC_KEY);
                    //Start Activity
                    Intent intent = new Intent(this, LoginActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);


         }else{
         Toast.makeText(mContext, "Network is unavailable. Request failed", Toast.LENGTH_LONG).show();
         }

}

}