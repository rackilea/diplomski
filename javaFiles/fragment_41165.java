ProfilePictureView profilePic = (ProfilePictureView) dialogView.findViewById(R.id.myProfilePic);
GraphRequestAsyncTask request = GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
    @Override
    public void onCompleted(JSONObject user, GraphResponse response) {
        if (user != null) {
            // set the profile picture using their Facebook ID
            profilePic.setProfileId(user.optString("id"));
        }
    }
}).executeAsync();