mDatabaseRefUser.child("Chatting").child(mAuth.getCurrentUser().getUid())
                .child(userID).child(uploadID).child("Messages").push().setValue(new ChatMessage(addMessageEditText.getText().toString(),
                mAuth.getCurrentUser().getEmail()));

        mDatabaseRefUser.child("Chatting").child(userID)
                .child(mAuth.getCurrentUser().getUid()).child(uploadID).child("Messages").push().setValue(new ChatMessage(addMessageEditText.getText().toString(),
                userEmail));