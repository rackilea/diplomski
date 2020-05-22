@Override
public void onDataChange(DataSnapshot dataSnapshot) {
    if (dataSnapshot.exists()) {
        for (DataSnapshot data : dataSnapshot.getChildren()) {
            User currentUser = data.getValue(User.class);
            Log.i("THE_SNAPSHOT_AS_STRIN", data.toString());
            Log.i("THE_USERS_EMAIL:::", currentUser.getEmail());
        }
    } else {
        // User does not exist at this point.
    }
}