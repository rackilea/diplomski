private void setUpTwitterButton() {
    twitterButton = (TwitterLoginButton) findViewById(R.id.twitter_button);
    twitterButton.setCallback(new Callback<TwitterSession>() {
        @Override
        public void success(Result<TwitterSession> result) {
            // TODO: success flow
        }

        @Override
        public void failure(TwitterException exception) {
            // TODO: failure flow
        }
    });
}