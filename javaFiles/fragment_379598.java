protected void onActivityResult(int requestCode, int resultCode, Intent data) {  
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {  
            thumbnailImage = (Bitmap) data.getExtras().get("data"); 

        }  
    }