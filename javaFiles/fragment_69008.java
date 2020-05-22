StorageReference storageRef = storage.getReference();
StorageReference photoRef = storageRef.child("YOUR_PATH" + userId + ".jpg");

photoRef.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
    @Override
    public void onSuccess(Void aVoid) {
        // Success
    }
}).addOnFailureListener(new OnFailureListener() {
    @Override
    public void onFailure(@NonNull Exception exception) {
       // Error
    }
});