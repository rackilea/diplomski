WriteBatch batch = db.batch();

DocumentReference johnRef = db.collection("users").document("John");
batch.set(johnRef, new User());

DocumentReference maryRef = db.collection("users").document("Mary");
batch.update(maryRef, "Anna", 20); //Update name and age

DocumentReference alexRef = db.collection("users").document("Alex");
batch.delete(alexRef);

batch.commit().addOnCompleteListener(new OnCompleteListener<Void>() {
    @Override
    public void onComplete(@NonNull Task<Void> task) {
        // ...
    }
});