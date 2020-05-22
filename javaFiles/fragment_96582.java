private class SessionStatusCallback implements Session.StatusCallback {
    private String fbAccessToken;

    @Override
    public void call(Session session, SessionState state, Exception exception) {
        updateView();
        if (session.isOpened()) {
            fbAccessToken = session.getAccessToken();
            // make request to get facebook user info
            Request.executeMeRequestAsync(session, new Request.GraphUserCallback() {
                @Override
                public void onCompleted(GraphUser user, Response response) {
                    Log.i("fb", "fb user: "+ user.toString());

                    String fbId = user.getId();
                    String fbAccessToken = fbAccessToken;
                    String fbName = user.getName();
                    String gender = user.asMap().get("gender").toString();
                    String email = user.asMap().get("email").toString();

                    Log.i("fb", userProfile.getEmail());
                }
            });
        }
    }
}