// consider you have you user (FirebaseUser) object ready
FirebaseDatabase.getInstance().getReference("Users/" + user.uid + "/chats")
    .addListenerForSingleValueEvent(new ValueEventListener() {
        ... onDataChange(DataSnapshot dataSnapshot) {
            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                FirebaseDatabase.getInstance().getReference("Messages/"+snapshot.getKey())
                    .addListenerForSingleValueEvent(...
                        ... onDataChange(DataSnapshot messageSnapshot) {
                            // I changed the snapshot name to make it easier to read
                            // here messageSnapshot.getKey() is message ID
                            // and messageSnapshot.getValue() will contain data you need (I think)
                        }
                        ...
                    );
            }
        }
        ...
    });