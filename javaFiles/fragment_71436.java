if (requestCode == LOAD_IMAGE && resultCode == RESULT_OK && data != null) {

        Uri selectedImage = data.getData();
        String[] filePathColumn = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
        cursor.moveToFirst();
        int index = cursor.getColumnIndex(filePathColumn[0]);
        imagePath = cursor.getString(index);
        cursor.close();
        profileImageView.setImageBitmap(BitmapFactory.decodeFile(imagePath));
        bitmap = BitmapFactory.decodeFile(imagePath); 
    }