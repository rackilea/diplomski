@Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == CAMERA_PHOTO && resultCode == Activity.RESULT_OK) {
                if(imageToUploadUri != null){
                    Uri selectedImage = imageToUploadUri;
                    getContentResolver().notifyChange(selectedImage, null);
                    Bitmap reducedSizeBitmap = getBitmap(imageToUploadUri.getPath());
                    if(reducedSizeBitmap != null){
                        ImgPhoto.setImageBitmap(reducedSizeBitmap);
                        Button uploadImageButton = (Button) findViewById(R.id.uploadUserImageButton);
                          uploadImageButton.setVisibility(View.VISIBLE);                
                    }else{
                        Toast.makeText(this,"Error while capturing Image",Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(this,"Error while capturing Image",Toast.LENGTH_LONG).show();
                }
            } 
        }