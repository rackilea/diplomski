if (firebaseUser != null) {
    for (UserInfo userInfo : firebaseUser.getProviderData()) {
        if (userInfo.getProviderId().equals("facebook.com")) {
            Log.d("TAG", "User is signed in with Facebook");
        }
    }
}