public void login(final LoginCallback loginCallback) {

 mApiService.login( developerKey, applicationKey, new Callback<User>() {

    @Override
    public void success ( User user, Response response ) {
        //code which should update user field
        loginCallback.ready();
    }

    @Override
    public  void failure ( RetrofitError error ) {

    }

} );