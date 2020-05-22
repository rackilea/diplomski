client.post(context,url,values , new AsyncHttpResponseHandler(Looper.getMainLooper()) {

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                callback.onSuccess(convertStreamToString(is[0]));
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
              callback.onFailure(); 
            }
}