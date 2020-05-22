private void postFacebookMessage() {
    AsyncFacebookRunner mAsyncRunner = new AsyncFacebookRunner(facebook);
    Bundle params = new Bundle();
    params.putString("message", "I am using great App!");
    params.putString("picture", "http://mysite.com/logo.jpg");
    mAsyncRunner.request("me/feed", params, "POST", new FacebookPostListener(), null);
}