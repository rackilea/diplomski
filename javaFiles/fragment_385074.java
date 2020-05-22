public class from_the_database {

    public void last_entry(String object, OnDataChangeCallback listener) {

        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        final String ok = object;
        Query query = database.child("records").orderByChild("object").equalTo(object);

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    for (DataSnapshot post : dataSnapshot.getChildren()) {
                        Data_model_milk dmm = 
                        post.getValue(Data_model_milk.class);
                        Log.e("value",dmm.getDate()); // this works though
                        listener.onDataChange("item was added last at " + dmm.getDate());
                    }
                } else {
                    listener.onDataChange("no insert for " + ok);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("from the db cancelled", databaseError.toString());
            }

        });
    }

    public interface OnDataChangeCallback{
        void onDataChange(String data);
    }
}