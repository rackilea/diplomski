public class ShareButtonActivity extends Activity {

    // SocialAuth Component
    SocialAuthAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // Welcome Message
        TextView textview = (TextView)findViewById(R.id.text);
        textview.setText("Title");

        //Create Your Own Share Button
        Button share = (Button)findViewById(R.id.sharebutton);
        share.setText("Share");
        share.setTextColor(Color.WHITE);
        share.setBackgroundResource(R.drawable.button_gradient);

        // Add it to Library
        adapter = new SocialAuthAdapter(new ResponseListener());

        // Add providers

        adapter.addProvider(Provider.TWITTER, R.drawable.twitter);

       //before that import library which is given by socialauth in link given below
        adapter.enable(share);

    }


    /**
     * Listens Response from Library
     * 
     */

    private final class ResponseListener implements DialogListener 
    {
        public void onComplete(Bundle values) {

            // Variable to receive message status

            Log.d("ShareButton" , "Authentication Successful");

            // Get name of provider after authentication
            String providerName = values.getString(SocialAuthAdapter.PROVIDER);
            Log.d("ShareButton", "Provider Name = " + providerName);

            adapter.updateStatus("your message|link" + System.currentTimeMillis());
            Toast.makeText(ShareButtonActivity.this, "Message posted on " + providerName, Toast.LENGTH_SHORT).show();       

         }

         public void onError(SocialAuthError error) {
             Log.d("ShareButton" , "Authentication Error");
         }

         public void onCancel() {
             Log.d("ShareButton" , "Authentication Cancelled");
         }

     }

}