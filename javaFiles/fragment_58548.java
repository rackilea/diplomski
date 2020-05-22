//add file on Firebase and got Download Link
filePath.putFile(imageUri).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
    @Override
    public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
        if (!task.isSuccessful()){
            throw task.getException();
        }
        return filePath.getDownloadUrl();
    }
}).addOnCompleteListener(new OnCompleteListener<Uri>() {
    @Override
    public void onComplete(@NonNull Task<Uri> task) {
        if (task.isSuccessful()){
            Uri downUri = task.getResult();
            Log.d(TAG, "onComplete: Url: "+ downUri.toString());
        }
    }
});