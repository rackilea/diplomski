mDatabase.child(wordNote_key).addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {

        String currentUid = (String) dataSnapshot.child("uid").getValue();

        if(firebaseauth.getCurrentUser().getUid().equals(currentUid)){

          viewHolder.nView.setVisibility(View.VISIBLE);
        }
        else
        {
            viewHolder.nView.setVisibility(View.GONE);
        }
        //Notify the adapter the viewholder at this position changed.
        notifiyItemChanged(position);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
});