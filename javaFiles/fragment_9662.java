StorageReference filepath = FirebaseStorage.getInstance().getReference().child("gpic");

    while (up < mArrayUri.size()){

        filepath.child(mArrayUri.get(k).getLastPathSegment()).putFile(mArrayUri.get(k)).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Uri downloadURL = taskSnapshot.getDownloadUrl();
                Toast.makeText(TestingActivity.this, downloadURL.toString(), Toast.LENGTH_SHORT).show();

            }
        });
        up++;
        k++;

    }

}