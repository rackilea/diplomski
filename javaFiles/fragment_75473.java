AndroidNetworking.get(ApiEndPoint.BASE_URL + ApiEndPoint.GET_JSON_ARRAY)
    .setTag(this)
    .addPathParameter("pageNumber", "0")
    .addQueryParameter("limit", "3")
    .setPriority(Priority.LOW)
    .build()
    .getAsJSONArray(new JSONArrayRequestListener() {
        @Override
        public void onResponse(JSONArray response) {
            Log.d(TAG, "onResponse array : " + response.toString());
        }

        @Override
        public void onError(ANError error) {
            if (error.getErrorCode() != 0) {
                // received ANError from server
                // error.getErrorCode() - the ANError code from server
                // error.getErrorBody() - the ANError body from server
                // error.getErrorDetail() - just a ANError detail
                Log.d(TAG, "onError errorCode : " + error.getErrorCode());
                Log.d(TAG, "onError errorBody : " + error.getErrorBody());
                Log.d(TAG, "onError errorDetail : " + error.getErrorDetail());
            } else {
                // error.getErrorDetail() : connectionError, parseError, requestCancelledError
                Log.d(TAG, "onError errorDetail : " + error.getErrorDetail());
            }
        }
    });