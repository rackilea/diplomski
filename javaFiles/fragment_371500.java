@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    try {
        // When an Image is picked
        if (requestCode == 1 && resultCode == RESULT_OK
                    && null != data) {
            // Get the Image from data

            String[] filePathColumn = { MediaStore.Images.Media.DATA };
            imagesEncodedList = new ArrayList<String>();
            if(data.getData()!=null){

                Uri mImageUri=data.getData();

                // Get the cursor
                Cursor cursor = getContentResolver().query(mImageUri,
                            filePathColumn, null, null, null);
                // Move to first row
                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                imageEncoded  = cursor.getString(columnIndex);
                cursor.close();

            }
        } else {
            Toast.makeText(this, "You haven't picked Image",
                        Toast.LENGTH_LONG).show();
        }
    } catch (Exception e) {
        Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG)
                    .show();
    }

    super.onActivityResult(requestCode, resultCode, data);
}