private void showFileChooser () {

        mHandler.post(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
            }
        });
}

private void showFileChooser2 () {

    mHandler.post(new Runnable() {
        @Override
        public void run() {

            Intent intent2 = new Intent();
            intent2.setType("image/*");
            intent2.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent2, "Select Picture"), PICK_IMAGE_REQUEST2);

        }
    });
}


 @Override
        protected void onActivityResult ( int requestCode, int resultCode, Intent data){
            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
                Uri filePath = data.getData();
                try {
                    //Getting the Bitmap from Gallery
                    bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                    rbitmap = getResizedBitmap(bitmap, 1000);//Setting the Bitmap to ImageView
                    imageViewUserImage.setImageBitmap(rbitmap);
                    bitmap.recycle;
                    imageViewUserImage.requestFocus();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else if (requestCode == PICK_IMAGE_REQUEST2 && resultCode == RESULT_OK && data != null && data.getData() != null) {
                Uri filePath2 = data.getData();
                try {
                    //Getting the Bitmap from Gallery
                    bitmap2 = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath2);
                    rbitmap2 = getResizedBitmap(bitmap2, 1000);//Setting the Bitmap to ImageView
                    imageViewUserImage2.setImageBitmap(rbitmap2);
                    bitmap2.recycle;
                    imageViewUserImage2.requestFocus();
                } catch (IOException e) {
                    e.printStackTrace();
                }
}
}