if (requestCode == SELECT_FILE && resultCode == RESULT_OK
                    && null != data) {


                Uri selectedImage = data.getData();
                String[] filePathColumn = { MediaStore.Images.Media.DATA };


                Cursor cursor = getContentResolver().query(selectedImage,
                        filePathColumn, null, null, null);

                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                imgPath = cursor.getString(columnIndex);
                cursor.close();
}else  if (requestCode == REQUEST_CAMERA && resultCode == RESULT_OK ) {  

                imgPath = fileUri.getPath();
                if (imgPath != null && !imgPath.isEmpty()) {                            

                encodeImagetoString();

                } else {
                Toast.makeText(getApplicationContext(),                                     getResources().getString(R.string.some_error_occured),
                                    Toast.LENGTH_LONG).show();
                        }
}