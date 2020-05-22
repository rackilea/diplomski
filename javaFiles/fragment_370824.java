Uri selectedImage = data.getData();
                    if (selectedImage == null) {
                        imagePath = data.getStringExtra(GOTOConstants.IntentExtras.IMAGE_PATH);

                        Bitmap my_bitmap_camera = BitmapFactory.decodeFile(imagePath);

                        ExifInterface exif = new ExifInterface(imagePath);
                        int orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);

                        switch (orientation){
                            case ExifInterface.ORIENTATION_ROTATE_90:
                                Matrix matrix = new Matrix();
                                matrix.postRotate(90);
                                my_bitmap_camera = Bitmap.createBitmap(my_bitmap_camera, 0, 0, my_bitmap_camera.getWidth(), my_bitmap_camera.getHeight(), matrix, true);
                                break;
                        }

                        ivScreenshot1.setImageBitmap(my_bitmap_camera);
                    }