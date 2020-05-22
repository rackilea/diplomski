FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
UserProfileChangeRequest userProfileChangeRequest = new UserProfileChangeRequest.Builder()
        .setDisplayName("aedgar777")
        .build();

firebaseUser.updateProfile(userProfileChangeRequest).addOnCompleteListener(new OnCompleteListener<Void>() {
    @Override
    public void onComplete(@NonNull Task<Void> task) {
        if (task.isSuccessful()) {
            Log.d(TAG, "aedgar777 updated!");
        }
    }
});