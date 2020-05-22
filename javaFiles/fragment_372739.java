final StorageReference childRef = storageReference.child("posts/" + user_id + "/" + ts + ".jpg");

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            compressedImageFile.compress(Bitmap.CompressFormat.JPEG, 18, baos);
            byte[] thumbData = baos.toByteArray();


            final UploadTask thumb_uploadTask = thumb_childRef.putBytes(thumbData);

            thumb_uploadTask.addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                    if (task.isSuccessful()) {
                        Task<Uri> thumb_uriTask = thumb_uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                            @Override
                            public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                                if (!task.isSuccessful()) {
                                    throw task.getException();
                                }
                                return thumb_childRef.getDownloadUrl();
                            }
                        }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                            @Override
                            public void onComplete(@NonNull Task<Uri> task) {
                                if (task.isSuccessful()) {

                                  Uri downloadUri = task.getResult();

                                                            final String mUri = downloadUri.toString();
                                                            final HashMap<Object, Object> dataMap = new HashMap<>();
                                                            dataMap.put("profile_image", profile_image);

                                                            if (bundle != null) {
                                                                group_id = bundle.getString("group_id");
                                                                dataMap.put("group_id", group_id);
                                                                mDatabase.child("group").child(group_id).child("posts").push().setValue(dataMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                    @Override
                                                                    public void onComplete(@NonNull Task<Void> task) {
                                                                        if (task.isSuccessful()) {
                                                                            pd.dismiss();
                                                                            Toast.makeText(getApplicationContext(), "Post added successfully", Toast.LENGTH_LONG).show();
                                                                            onBackPressed();
                                                                        } 
                                                                    }
                                                                });
                                }
                            }
                        });
                    }

                }
            });