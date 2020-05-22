private Long retreivedValue; // starts as null

public static void updateSomething(Long data) {
    System.out.println(data); // this line works
}

public static void main(String... args) {
    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

    ref.addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {

            retrievedValue = (Long) dataSnapshot.getValue();

            updateSomething(retrievedValue); 
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });