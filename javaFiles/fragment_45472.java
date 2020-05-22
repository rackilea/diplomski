userRef = new Firebase(FIREBASE_TO_HOME_TO_USERACCTS).child(bountyHuntPrefs.getString(USER_PREF_AUTH, ""));
userRef.addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        UserAccount user = dataSnapshot.getValue(UserAccount.class);
        userEmail = user.getUserName();
        if (userScore == 0)
            userScore = user.getScore();
        prefEditor.putLong(USER_PREF_SCORE, userScore).apply();
    }