private AccessTokenTracker fbTracker;
    ...
    fbTracker = new AccessTokenTracker() {
                @Override
                protected void onCurrentAccessTokenChanged(AccessToken accessToken, AccessToken accessToken2) {
                    if (accessToken2 == null) {
                        Log.d("FB", "User Logged Out.");
                    }
                }
            };