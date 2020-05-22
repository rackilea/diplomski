private void onSessionStateChange(Session session, SessionState state, Exception exception) {
        if (state.isOpened()) {
            if (isSessionCalled == false) {
                Log.i(TAG, "Logged in...");
                System.out.println("Token=" + session.getAccessToken());

                new Request(
                        session,
                        "/me",
                        null,
                        HttpMethod.GET,
                        new Request.Callback() {
                            public void onCompleted(Response response) {
                                if (response != null) {
                                    GraphObject object = response.getGraphObject();
                                    String email = (String) object.getProperty("email");
                                    Log.i(TAG, "user email : " + email);
                                    String firstName = (String) object.getProperty("first_name");
                                    String lastName = (String) object.getProperty("last_name");
                                    mUserTask = new UserAsyncTask();
                                    mUserTask.execute(email);
                                }

                            }

                        }
                ).executeAsync();

                isSessionCalled = true;
            }
            else {
                Log.w(TAG, "session called twice");
            }

            }

        else if (state.isClosed()) {
            Log.i(TAG, "Logged out...");
        }
    }