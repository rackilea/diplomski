public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
        UsersOnlineClass deletedUser = dataSnapshot.getValue(UsersOnlineClass.class);
        for (int i = 0; i < usersList.size(); i++) {
            if (usersList.get(i).getmuserName().equals(deletedUser.getmuserName())) {
                usersList.remove(i);
            }
        }