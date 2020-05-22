facebookrunner.request("me", new RequestListener() {
    @Override
    public void onComplete(String response, Object state) {
        //We are in the UI thread now
    }

    //Override the other methods, all are in the UI thread

});