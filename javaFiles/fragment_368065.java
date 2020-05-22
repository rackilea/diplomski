GraphRequest request = GraphRequest.newMeRequest(
        accessToken,
        new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(
                   JSONObject object,
                   GraphResponse response) {
                // your logic
            }
        });
Bundle parameters = new Bundle();
parameters.putString("fields", "id,name,link");
request.setParameters(parameters);
request.executeAsync();