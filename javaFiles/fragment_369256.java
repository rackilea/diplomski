final FirebaseRemoteConfig firebaseRemoteConfig = FirebaseRemoteConfig.getInstance();

 // set in-app defaults
 Map<String, Object> remoteConfigDefaults = new HashMap();
 remoteConfigDefaults.put("CURRENT_VERSION", "2.0");
  //...any other defaults here

 firebaseRemoteConfig.setDefaults(remoteConfigDefaults);
 firebaseRemoteConfig.fetch(60) // set the value in second to fetch every minutes
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "remote config is fetched.");

                        }
                    }
                });