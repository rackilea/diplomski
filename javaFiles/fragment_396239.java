//Upload the video to storage
        StorageReference mFirebaseStorageRef = FirebaseStorage.getInstance().getReference();

        mFirebaseStorageRef
                .child(String.valueOf(mCurrentUser.getEmail() + new Date().getTime()))
                .putFile(videoData).
                addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        try {

                            //MAYBE UPDATE IT SOMEPLACE IN DATABASE AS WELL
                            HashMap<String, String> city_Obj = new HashMap<String,String>();
                            city_Obj.put("VIDEO_URL", downloadUrl);
                            city_Obj.put("VIDEO_NAME", nameOfVideo);
                            city_Obj.put("VIDEO_DESC", descriptionOfVideo);
                            dbRef.child("CITIES").child(spinnerCityName).push().setValue(city_Obj);


                        } catch (Exception e) {
                            e.printStackTrace();
                            Log.e("DB ERROR", e.getMessage());
                        }