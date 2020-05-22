protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        try {
            if (requestCode == REQUEST_TAKE_PHOTO && resultCode == RESULT_OK) {
        Uri uri = intent.getData(); // you need take uri of image
        imageView.setImageURI(uri); // you don't need of picasso to load local images     


           //     Picasso.get().load(file).into(imageView);

//                Bitmap bitmap = MediaStore.Images.Media
//                        .getBitmap(this.getContentResolver(), Uri.fromFile(file));
//                if (bitmap != null) {
//                    imageView.setImageBitmap(bitmap);
//                }
            } else if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK) {
                File file = new File(mCurrentPhotoPath);
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), Uri.fromFile(file));
                if (bitmap != null) {
                    imageView.setImageBitmap(bitmap);
                }
            }

        } catch (Exception error) {
            error.printStackTrace();
        }
    }