ShareApi.share("My message", content, new FacebookCallback<Sharer.Result>() {

        @Override
        public void onSuccess(Sharer.Result result) {
            if (AppConfig.DEBUG) {
                Log.d(TAG, "SUCCESS");
            }
        }

        @Override
        public void onCancel() {
            if (AppConfig.DEBUG) {
                Log.d(TAG, "CANCELLED");
            }
        }

        @Override
        public void onError(FacebookException error) {
            if (AppConfig.DEBUG) {
                Log.d(TAG, error.toString());
            }
        }
    });