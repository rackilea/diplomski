FirebaseInstanceId.getInstance().getInstanceId()
    .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
        @Override
        public void onComplete(@NonNull Task<InstanceIdResult> task) {
            if (!task.isSuccessful()) {
                return;
            }

            // Get new Instance ID token and send to server
            String token = task.getResult().getToken();
            sendTokenToServer(token);
        }
    });