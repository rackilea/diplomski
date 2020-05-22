Bundle params = new Bundle();
            params.putString("message", "Contents of message");
            //here, token is our newly created AccessToken object
            GraphRequest request = new GraphRequest(token, "/pageid/feed", params, HttpMethod.POST, new GraphRequest.Callback() {
                public void onCompleted(GraphResponse response) {
                    FacebookRequestError error = response.getError();
                    if (error != null) {
                        Log.e("Error", error.getErrorMessage());

                    } else {
                        //do your own processing here for success
                    }


                }
            });
            GraphRequest.executeAndWait(request);
        }
    }