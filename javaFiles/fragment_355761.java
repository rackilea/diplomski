protected void onActivityResult(int requestCode, int resultCode, Intent data) {  
    if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {  
        Bitmap photo = (Bitmap) data.getExtras().get("data"); 
        imageView.setImageBitmap(photo);
    }  
}