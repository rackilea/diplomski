@Override
protected void onCreate(Bundle savedInstanceState) {

    ...

    Button sharebutton = (Button) findViewById(R.id.share_button);
    sharebutton.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
            if (facebook.isSessionValid()) {
                postFacebookMessage();
            } else {
                facebook.authorize(YourActivity.this, new String[] {"publish_stream"}, new FacebookAuthListener() {
                    @Override
                    public void onComplete(Bundle values) {
                        postFacebookMessage();
                    }
                });
            }
        }
    });

    ...
}