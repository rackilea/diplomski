if(!TextUtils.isEmpty(title)  && !TextUtils.isEmpty(description) && uri!=null) {
    StorageReference filepath = reference.child("images/"+ UUID.randomUUID().toString());
    filepath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
        @Override
        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
            Toast.makeText(Add_Post.this, "Uploaded", Toast.LENGTH_SHORT).show();
            pd.dismiss();
        }
    });
}