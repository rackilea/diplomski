Document doc = null;

        protected void onCreate(Bundle icicle) {
            super.onCreate(icicle);
            setContentView(R.layout.splash);

            new GetHTMLContent().excute();


        }

        private static class GetHTMLContent extends AsyncTask<Void, Void, Document> {

            protected Document doInBackground(Void... args) {
                try {
                    return Jsoup.connect(DROP_DATA_URL).get();
                } catch(Exception e) {
                    return null;
                }
            }

            protected void onPostExecute(Document html){
                doc = html;
                Utils.saveData(Splash.this, doc);
                goToMainActivity();


            }
        }

        private void goToMainActivity(){
            new Handler().postDelayed(new Runnable(){
                @Override
                public void run() {
                    /* Create an Intent that will start the Menu-Activity. */
                    Intent mainIntent = new Intent(Splash.this, PocketFrameNavigation.class);
                    Splash.this.startActivity(mainIntent);
                    Splash.this.finish();
                }
            }, SPLASH_DISPLAY_LENGTH);
        }

}