.
.
.

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
auth = new TwitterAuth(CheckLib.this, CONSUMER_KEY, CONSUMER_SECRET);
auth.setListener(new TwitterLoginListener{

     @Override
     public void success(Result<TwitterSession> twitterSessionResult){
        //login success
     }

     @Override
     public void failure(TwitterException e){
        //login failed
     }
}); 
.
.
.