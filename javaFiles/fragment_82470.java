public void _doneClicked(View view)
{
    final StorageReference sss=firebaseStorage.child("Display Pictures").child(UId);
    UploadTask up=sss.putFile(imageURI);
    Task<Uri> task=up.
            continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
        @Override
        public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
            if (!task.isSuccessful()) {
                throw task.getException();
            }
            // Continue with the task to get the download URL
            else
            return sss.getDownloadUrl();
        }
    })
            .addOnCompleteListener(new OnCompleteListener<Uri>() {
        @Override
        public void onComplete(Task<Uri> task) {
            if (task.isSuccessful()) {
                downloadurl = task.getResult();
                Log.i("Done",downloadurl.toString());
                Fname=((EditText)findViewById(R.id.firstName)).getText().toString();
                Lname=((EditText)findViewById(R.id.lastName)).getText().toString();
                setResult(RESULT_OK);
                finish();
            }
        }
    });
}