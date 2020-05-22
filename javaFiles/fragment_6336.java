private void checkFriendRequestStatus(final ButtonStatus buttonsCallback, final String strSignedInUID, final String visitedUsername, final String strVisitedUID) {
        final DatabaseReference checkFriendRequestsRef = database.getReference("friend_requests/test/" + strSignedInUID);
        checkFriendRequestsRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                // choice is 1 to show buttons, then select which buttons to show with second params
                if (dataSnapshot.child("friends/" + visitedUsername).getValue(String.class).equals(strVisitedUID)) {
                    buttonsCallback.setButtonStatus(1, 1);
                }
                else if (dataSnapshot.child("sentFriendRequest/" + visitedUsername).getValue(String.class).equals(strVisitedUID)) {
                    buttonsCallback.setButtonStatus(1, 2);
                }
                else if (dataSnapshot.child("receivedFriendRequests/" + visitedUsername).getValue(String.class).equals(strVisitedUID)) {
                    buttonsCallback.setButtonStatus(1, 3);
                }
                else {
                    buttonsCallback.setButtonStatus(1, 4);;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }