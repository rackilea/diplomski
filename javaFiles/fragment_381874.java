private void startPosting(Bitmap bmp) {
    byte[] data = bmp.toByteArray();
    mProgress.setMessage("Uploading Image...");

    final String title_val = mPostTitle.getText().toString().trim();
    final String desc_val = mPostDesc.getText().toString().trim();
    if (!TextUtils.isEmpty(title_val) && !TextUtils.isEmpty(desc_val) && filePath != null) {
        mProgress.show();
        StorageReference filepath = mStorage.child("BlogImages").child(uri_image_final.getLastPathSegment());


        UploadTask uploadTask = filepath.putBytes(data);
        uploadTask.addOnFailureListener(new OnFailureListener() {
              @Override
              public void onFailure(@NonNull Exception exception) {
                // Handle unsuccessful uploads
              }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
              @Override
              public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

            Uri downloadUri = taskSnapshot.getDownloadUrl();
            DatabaseReference newPost = mDatabase.push();
            DatabaseReference c = mDatabase.push();
            newPost.child("EventTitle").setValue(title_val);
            newPost.child("EventDescription").setValue(desc_val);
            newPost.child("EventImage").setValue(downloadUri.toString());
            newPost.child("PostId").setValue(c);



            mProgress.dismiss();
            startActivity(new Intent(PostActivity.this, MainActivity.class));


        }
    });


    } else if (TextUtils.isEmpty(title_val) && TextUtils.isEmpty(desc_val) && imageUri != null) {
        mProgress.show();
        StorageReference filepath = mStorage.child("BlogImages").child(uri_image_final.getLastPathSegment());
        UploadTask uploadTask = filepath.putBytes(data);
        uploadTask.addOnFailureListener(new OnFailureListener() {
              @Override
              public void onFailure(@NonNull Exception exception) {
                // Handle unsuccessful uploads
              }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
              @Override
              public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                Uri downloadUri = taskSnapshot.getDownloadUrl();
                DatabaseReference newPost = mDatabase.push();
                newPost.child("EventTitle").setValue("");
                newPost.child("EventDescription").setValue("");
                newPost.child("EventImage").setValue(downloadUri.toString());


                mProgress.dismiss();
               // startActivity(new Intent(PostActivity.this, MainActivity.class));
                Intent load=  new Intent(PostActivity.this,MainActivity.class);
                load.putExtra(eventname,eventname);
                startActivity(load);


            }
        });

    }

    else if (!TextUtils.isEmpty(title_val) && !TextUtils.isEmpty(desc_val) && imageUri== null){

        Toast.makeText(getApplicationContext(),"Please insert an Image and Upload ! ",Toast.LENGTH_LONG).show();

    }
}