public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {
    @Override
    protected Boolean doInBackground(Void... params) {
        // TODO: attempt authentication against a network service.

        final ResponseContainer responseContainer = new ResponseContainer();
        Network.login(mEmail, mPassword, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers,
                    byte[] responseBody) {

                if (statusCode == 200) {
                    // Successfully got a response
                    for (int i = 0; i < headers.length; i++) {
                        if (headers[i].getName().equalsIgnoreCase("token")) {
                            // Set the token to the received value
                            Network.SetToken(headers[i].getValue());
                    // >>>>>>>      return true;   <<<<<<<<<
                            responseContainer.result = true;
                        }
                    }
                }
                // >>>>> return false  <<<<<<<<<<<<
                responseContainer.result = false;
            }

            @Override
            public void onFailure(int statusCode, Header[] headers,
                    byte[] responseBody, Throwable error) {
                // Response failed :(
                  //     >>>>>>>>>>>>>>>>>> return false <<<<<<<<<<<<<
                responseContainer.result = false;
            }           
        });

        // TODO: register the new account here.
        return responseContainer.result;
    }

    @Override
    protected void onPostExecute(final Boolean success) {
        mAuthTask = null;
        showProgress(false);

        if (success) {
            finish();
        } else {
            mPasswordView
                    .setError(getString(R.string.error_incorrect_password));
            mPasswordView.requestFocus();
        }
    }

    private class ResponseContainer {
        public boolean result;
    }
}