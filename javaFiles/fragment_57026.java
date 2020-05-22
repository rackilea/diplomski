FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
            .continueWithTask(new Continuation<AuthResult, Task<? extends Object>>() {
                @Override
                public Task<? extends Object> then(@NonNull Task<AuthResult> task) throws Exception {
                    UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                            .setDisplayName("XXX YYYY")
                            .setPhotoUri(URI)
                            .build();
                    return task.getResult().getUser().updateProfile(profileUpdates);
                }
            });