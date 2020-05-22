@Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == CAMERA_PHOTO && resultCode == Activity.RESULT_OK) {
                if(imageToUploadUri != null){
                    Uri selectedImage = imageToUploadUri;
                    getContentResolver().notifyChange(selectedImage, null);
                    Bitmap reducedSizeBitmap = getBitmap(imageToUploadUri.getPath());
                    if(reducedSizeBitmap != null){
                        imageview.setImageBitmap(reducedSizeBitmap);
                    }else{
                        Toast.makeText(this,"Error while capturing Image",Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(this,"Error while capturing Image",Toast.LENGTH_LONG).show();
                }
            } 
        }