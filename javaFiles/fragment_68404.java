RestAdapter.Builder builder = new RestAdapter.Builder()
    .setRequestInterceptor(new RequestInterceptor() {
        @Override
        public void intercept(RequestFacade request) {
            request.addHeader("Accept", "application/json;versions=1");
            if (isUserLoggedIn()) {
                request.addHeader("Authorization", getToken());
            }                    
        }
    });