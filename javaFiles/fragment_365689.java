public void storeImage(Uri imageUri) {
    StorageReference filepath = mStorage.child(" Images");
    filepath.putFile(imageUri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
        @Override
        public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {

            if (task.isSuccessful()){

                Toast.makeText(ImageVersus.this, " Published", Toast.LENGTH_SHORT).show();

            }
            else{
                Toast.makeText(ImageVersus.this, "..Error..", Toast.LENGTH_SHORT).show();
            }

        }
    });

}