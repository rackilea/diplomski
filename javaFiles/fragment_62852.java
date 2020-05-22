Profile profile = Profile.getCurrentProfile();
    if(null != profile) {
          new ProfileTracker() {
                                @Override
                                protected void onCurrentProfileChanged(Profile oldProfile, Profile currentProfile) {
                                    if (currentProfile != null) {
                                        // handle it
                                        stopTracking();
                                    }
                                }
                            }.startTracking();
    } else {
            textView.setText(profile.getName());
}